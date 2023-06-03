    
   function resvValueCheck(){
    var number1 = document.getElementById('mobile1').value;
    var number2 = document.getElementById('mobile2').value;
    var number3 = document.getElementById('mobile3').value;

    resvObj.number = number1 +'-' + number2 + '-' +number3;
    resvObj.customerName = document.getElementById('customer_name').value;

    resvObj.guest = resvObj.adult + resvObj.child;

    resvObj.request = document.getElementById('bul01').value;

   }
   
    const resvObj = {
        customerName : "",
        resvDate :"",
        resvTime : "",
        number : "",
        email : "",
        adult : "",
        child : "",
        guest : "",
        request : "",
        menu : "",
        amount : ""
    }



function requestPay() {

    IMP.init('imp54127217'); //iamport 대신 자신의 "가맹점 식별코드"를 사용
    IMP.request_pay({
      pg: "html5_inicis",
      pay_method: "card",
      merchant_uid : 'merchant_'+new Date().getTime(),
      name : '결제테스트',
      amount: resvObj.amount,
      buyer_email: "test",
      buyer_name: "test",
      buyer_tel: "test",
    }, function (rsp) { // callback
        if (rsp.success) {
            console.log(resvObj);
            $.ajax({
                async : false,
                type : "post",
                url: "http://localhost:8000/api/payment/complete",
                contentType: 'application/json',
                data: JSON.stringify(resvObj),
                dataType : "json",
                success : response => {
                    console.log(response);
                    successFlag = true;
                }                
            })
            location.href = "/menulist" ;
        } else {
            alert("결제에 실패하였습니다. 에러 내용: " + rsp.error_msg);
        }
    });

}