function loginCheck(){
  var adminID = $('input[name="userId]').val();
  var pwd = $('input["pwd"]').val();
  var ckeck = $('#save_id:checked').val();

  const adminObj = {
    adminID: "",
    pwd: ""
  }

  $.ajax({
    type: "post",
    url: "http://localhost:8000/admin/login",
    contentType : "application/json",
    data : JSON.stringify(adminObj),
    success : function(result) => {
      successFlag = true;
    },
    error : error =>{
      console.log(error);
      resvRegisterService.getInstance().setErrors(error.responseJSON.data);
    }
  })
}