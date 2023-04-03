window.onclick = () => {
  const registerButton = document.getElementById("reserveButton");
  registerButton.onclick = () => {
    console.log("클릭됨");
    
    ImportApi.getInstance().requestPay();
    
  }
}

const resvObj = {
  customerName: "",
  resvDate: "",
  resvTime: "",
  number: "",  
  email: "",
  adult: "",
  child: "",
  guest: "",
  resvmenu: ""
}

class resvRegisterApi{
  static #instance = null;
  static getInstance() {
    if(this.#instance ==null) {
      this.#instance = new resvRegisterApi();
    }
    return this.#instance;
  }

    registerResv(){
      let successFlag = false;
  
    $.ajax({
      async : false,
      type : "post",
      URL : "http://localhost:8000/api/resv",
      contentType : "application/json",
      data : JSON.stringify(resvObj),
      dataType : "json",
      success : response => {
        console.log(response);
        successFlag = true;
      },
      error : error =>{
        console.log(error);
        resvRegisterService.getInstance().setErrors(error.responseJSON.data);
      }

    });

    return successFlag;
    
  }
}

class resvRegisterService {
  static #instance = null;
  static getInstance() {
    if(this.#instance ==null) {
      this.#instance = new resvRegisterService();
    }
    return this.#instance;
  }

  setResvObjValue(){
    resvRegisterApi.getInstance().registerResv();
    const registerInputs = document.querySelectorAll(".register-input"); //예약정보
    const registerInput_nm = document.querySelectorAll(".cust_nm"); //인원수

    var NumberHyphen = '-';
    var mobile1 =  $('option[name="mobile1"]:checked').val();
    var mobile2 = document.querySelectorAll(".mobile2").value;
    var mobile3 = document.querySelectorAll(".mobile3").value;

    var email_01 = document.getElementById("#email_1");
    var email_02 = $('option[name="email_2"]:checked').val
    var emailHyphen = '@';

    resvObj.customerName = registerInput_nm.value;      
    resvObj.resvDate = registerInputs[0].value;
    resvObj.resvTime = registerInputs[1].value;

    // resvObj.number = mobile1.concat(NumberHyphen, mobile2, NumberHyphen, mobile3);
    // resvObj.email = email_01.concat(emailHyphen, email_02);

    resvObj.guest = registerInputs[2].value; //인원 총합
    resvObj.resvmenu = registerInputs[3].value;

  }

  clearErrors(){
    const errorMessages = document.querySelectorAll(".error-message");
    errorMessages.forEach(error => {
      error.innerHTML ="";
    })
  }
}

class ImportApi {
  static #instance = null;
  static getInstance () {
      if(this.#instance == null) {
          this.#instance = new ImportApi();
      }
      return this.#instance;
  
  }

  IMP = null;

  importInfo = {
      impuid: "imp54127217",
      restApikey: "8663540250674387",
      restApiSecret: "m2I82XnYYSG1MKf1VxQ7hOL3r4bFf3U1eWsVyJxFwvN5nRhGu5GUUzhbNXo29X27lmkqvUEsUkWpWRQZ"
  }
  
  importPayParams= {
      pg: "html5_inicis",
      pay_method: "card",
      merchant_uid : 'merchant_'+ new Date().getTime(),
      name : '결제테스트', 
      amount : 100, 
      buyer_email : 'iamport@siot.do',
      buyer_name : '구매자',
      buyer_tel : '010-1234-5678',
      buyer_addr : '서울특별시 강남구 삼성동',
      buyer_postcode : '123-456'
  }

  constructor() {
      this.IMP = window.IMP;
      this.IMP.init(this.importInfo.impuid);
  }

  requestPay() {
      this.IMP.request_pay(this.importPayParams, this.responsePay);
  }

  responsePay(resp) {
    
      console.log(resp);
      if(resp.success) {  
          alert("결제 성공");
          resvRegisterService.getInstance().setResvObjValue();
          
          location.href = "http://localhost:8000/menulist";
      }else {
          alert("결제 실패");
      }
    }
}
