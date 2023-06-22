window.onload = () => {
  console.log(JSON.parse(localStorage.getItem('sendcheckObj')));

checkReserveEvent.getInstance().loadCheckData();
ReservationModificationService.getInstance().setModifyValue();
}

let checkObj={
  reserveId : null,
  number : null
}

const Modifyvalue = {
date : "",
time : "",
adult : "",
child : "",
resquest : ""
}
checkObj = JSON.parse(localStorage.getItem('sendcheckObj'));
console.log(checkObj);


class ModificationApi {
  static #instance = null;
  static getInstance() {
      if(this.#instance == null) {
          this.#instance = new ModificationApi();
      }
      return this.#instance;
  }

Modify_getReserveData() {
  let returnData = null;

  $.ajax({
    async: false,
    type: "get",
    url: "http://localhost:8000/api/check",
    data: checkObj,
    dataType: "json",
    success: response => {
      console.log(response);
              returnData = response.data;
    },
    error: error => {
      console.log(error);
    }
  });

  return returnData;
}

modifyReserveInfo(){
  let successFlag = false;

      $.ajax({
          async: false,
          type: "put",
          url: `http://localhost:8000/api/user/${checkObj.reserveId}`,
          contentType: "application/json",
          data: JSON.stringify(checkObj),
          dataType: "json",
          success: response => {
              console.log(response);
              successFlag = true;
          },
          error: error => {
              console.log(error);
          }
      });

      return successFlag;
}
}

class ReservationModificationService {
  static #instance = null;
  static getInstance() {
      if(this.#instance == null) {
          this.#instance = new ReservationModificationService();
      }
      return this.#instance;
  }

setModifyValue(){

  const modifytime = document.getElementById('timeSelect');
  const modifyadult = document.getElementById('adultSelect');
  const modifychild = document.getElementById('childSelect');

  Modifyvalue.date = document.getElementById('dateSelect').value;
  Modifyvalue.time = modifytime.options[modifytime.selectedIndex].text;
  Modifyvalue.adult = modifyadult.options[modifyadult.selectedIndex].text;
  Modifyvalue.child = modifychild.options[modifychild.selectedIndex].text;
  Modifyvalue.resquest = document.querySelector('.modification-input-request').value;

  console.log(Modifyvalue);
}
  
}

class checkReserveEvent {
  static #instance = null;
  static getInstance() {
      if(this.#instance == null) {
          this.#instance = new checkReserveEvent();
      }
      return this.#instance;
  }

  loadCheckData(){
  const checkData = ModificationApi.getInstance().Modify_getReserveData();
  const checkContents1 = document.querySelector(".reserve-contents1 tbody");
  const checkContents2 = document.querySelector(".reserve-contents2 tbody");
  const checkContents3 = document.querySelector(".reserve-contents3 tbody");
  const checkContents4 = document.querySelector(".reserve-contents4 tbody");
  console.log(localStorage.getItem('checkObj'));

      console.log(checkData);
  checkData.forEach(data => {
    checkContents1.innerHTML += `
      <tr>                       
        <th>성명(한글)</th>
        <td>${data.reserveName}</td> 
      </tr>
      <tr>                       
        <th>예약번호</th>
        <td class="reserve-id">${data.reserveId}</td>
      </tr>
      <tr>
        <th>연락처</th>
        <td>${data.number}</td>
      </tr>        
      <tr>
        <th>이메일</th>
        <td>${data.email}</td>
      </tr>  
    `;
  });

  checkData.forEach(data => {
    checkContents2.innerHTML += `
    <tr>                       
      <th>예약일</th> 
      <td>${data.reserveDate}</td>
    </tr>
    <tr>
      <th>예약시간</th>
      <td>${data.reserveTime}</td>
    </tr>
  `;
  });
  checkData.forEach(data => {
    checkContents3.innerHTML += `
      <tr> 
        <th>대인</th>
        <td>${data.adult}명</td>
      </tr>
      <tr>
        <th>소인</th>
        <td>${data.child}명</td>
      </tr>
    `;
  });
  checkData.forEach(data => {
    document.querySelector('.modification-input-request').value = data.request;

  });
  }

}