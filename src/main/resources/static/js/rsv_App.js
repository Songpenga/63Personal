
// const priceAmount = $('#price').val();

// function requestPay() {
//     IMP.init("imp54127217"); //iamport 대신 자신의 "가맹점 식별코드"를 사용
//     IMP.request_pay(
//       {
//         pg: "html5_inicis",
//         pay_method: "card",
//         merchant_uid: "merchant_" + new Date().getTime(),
//         name: "결제테스트",
//         amount: 100,
//         buyer_email: resvObj.email,
//         buyer_name: resvObj.customerName,
//         buyer_tel: resvObj.number,

//       }, function (rsp) {
//         console.log(rsp);
//         ComponentEvent.getInstance().addClickEventRegisterButton();
//         if (rsp.success) {
//           var msg = "결제가 완료되었습니다.";
//           alert(msg);
//           location.href ="http://localhost:8000/menulist"
          
//         } else {
//           var msg = "결제에 실패하였습니다.";
//           msg += "에러내용 : " + rsp.error_msg;
//           alert(msg);
//         }
//       }
//     );
//   }
  