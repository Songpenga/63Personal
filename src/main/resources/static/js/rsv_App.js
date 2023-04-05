    
    var number1 = document.getElementById('mobile1').value;
    var number2 = document.getElementById('mobile2').value;
    var number3 = document.getElementById('mobile3').value;

    const resvObj = {
        customerName : document.getElementById('customer_name').value,
        resvDate :document.getElementById('check01').value,
        resvTime : document.getElementById('check02').value,
        number : "Resvnumber",
        email : "Resvemail",
        adult : "Resvadult",
        child : "Resvchild",
        guest : "5",
        amount : "100"
    }

    var resvEmail = document.getElementById('email_1').value;
    var domain = document.getElementById('email_txt').value;

    resvObj.customerName = document.getElementById('customer_name').value;
    resvObj.resvDate = document.getElementById('check01').value;
    resvObj.resvTime = document.getElementById('check02').value;;
    resvObj.number = number1 +'-' + number2 + '-' +number3;
    resvObj.email = resvEmail + '@' + domain;
    resvObj.adult = document.getElementById("count01").innerText;
    resvObj.child = document.getElementById("count02").innerText;

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
                    location.replace('/menulist');
                }
            }).done(function (rsp) {
                location.replace('/menulist');
            })
        } else {
            alert("결제에 실패하였습니다. 에러 내용: " + rsp.error_msg);
        }
    });

}