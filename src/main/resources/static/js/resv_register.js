window.onload = () =>{

}

const resvObj = {
  customerName: "",
  resvDate: "",
  resvTime: "",
  resvmenu: "",
  number: "",
  email: "",
  adult: "",
  child: ""
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
      URL : "http://localhost:8000/",
      contentType : "application/json",
      data : JSON.stringify(bookObj),
      dataType : "json",
      success : response => {
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
      const registerInputs = document.querySelectorAll("register-input");

      resvObj.customerName = registerInputs[0].value;
      resvObj.resvDate = registerInputs[1].value;
      resvObj.resvTime = registerInputs[2].value;
      resvObj.resvmenu = registerInputs[3].value;
      resvObj.email = registerInputs[4].value;
      resvObj.adult = registerInputs[5].value;
      resvObj.child = registerInputs[6].value;

    }

    setErrors(errors){//필수작성란
      const errorMessages = document.querySelectorAll(".error-message");
      this.clearErrors();

      Object.keys(errors).forEach(key=>{
        if(key == "customerName"){
          errorMessages[0].innerHTML= errors[key];
        }else if(key=="resvDate"){
          errorMessages[1].innerHTML= errors[key];
        }else if(key=="email"){
          errorMessages[4].innerHTML= errors[key];
        }
      })
    }

    clearErrors(){
      const errorMessages = document.querySelectorAll(".error-message");
      errorMessages.forEach(error => {
        error.innerHTML ="";
      })
    }

    addClickEventResvButton() {
      const registerButton = document.querySelector(".register-button");
  
      registerButton.onclick = ()=>{
  
        resvRegisterService.getInstance().setBookObjValues();
        const successFlag = resvRegisterApi.getInstance().registerBook();
        // BookRegisterApi.getInstance().registerBook(); => true
  
        if(!successFlag) { //successFlag 가 true가 아니면 등록취소해라.
          return;
        }
  
        if(confirm("예약하시겠습니까?")){
          const resvAddButton = document.querySelector(".resv-add-button");
          const resvCancelButton = document.querySelector(".resv-cancel-button");
  
          resvAddButton.disabled = false;
          resvCancelButton.disabled = false;
        }else{
          location.reload(); //아예 새로고침, 기존작성해놓은거까지.
        }
  
      }
    }
}