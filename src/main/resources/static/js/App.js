    window.onload = () => {
      const paymentButton = document.querySelector(".payment-button");
      paymentButton.onclick = () => {
          // const inputs = document.querySelectorAll(".product-input"); 

        // const registerInputs = document.querySelectorAll(".register-input"); //예약정보
        // const registerInput_nm = document.querySelectorAll(".cust_nm"); //인원수

        //   ImportApi.getInstance().importPayParams.name = registerInput_nm.value;
        //   ImportApi.getInstance().importPayParams.amount = registerInputs[2].value;
        ImportApi.getInstance().requestPay();
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
          restApiSeret: "m2I82XnYYSG1MKf1VxQ7hOL3r4bFf3U1eWsVyJxFwvN5nRhGu5GUUzhbNXo29X27lmkqvUEsUkWpWRQZ"
      }
      importPayParams= {
        pg: "kakaopay",
        pay_method: "card",
        merchant_uid: "merchant_" + new Date().getTime(),
        name: "결제테스트", //주문 메뉴
        amount: 1000, //예약 금액 
        buyer_email: "iamport@siot.do", //이메일
        buyer_name: "구매자", //예약자명
        buyer_tel: "010-1234-5678",
      }
  
      constructor() {
          this.IMP = window.IMP;
          this.IMP.init(this.importInfo.impuid);
      }
      requestPay() {
          this.IMP.request_pay(this.importPayParams, this.responsePay);
      }
  
      responsePay(resp) {
          console.log(resp)
          if(resp.success) {
              alert("결제 성공");//여기에 getInstanse
          }else {
              alert("결제 실패");
          }
      }
  }
