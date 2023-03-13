function f_loginCheck(){
  var userId = $('input[name="adminId"]').val();
  var pwd = $('input[name="admminPw"]').val();
    /**
  * 아래는 localStorage를 활용한 아이디 기억을 사용하기 위함입니다.
  * 아이디 저장 checkbox가 선택된 상태로 로그인 버튼을 클릭하면 
  * 다음 login 페이지로 접속할 시 document.ready시점에 localStorage.getItem("saveId")
  * 값이 '', null, 'N' 중에 없을 시에만 id input란에 값을 넣어주면 됩니다.
  */
  // if(saveIdCheck == 'on'){
  //     localStorage.setItem("saveId", userId);
  // } else{
  //     localStorage.setItem("saveId", 'N');    
  // }

  var loginData = {"userId":userId, "pwd":pwd};

  $.ajax({
      type: "POST",
      url: "localhost:8000/admin/login",
      contentType : "application/json",
      data : JSON.stringify(loginData),
      success : function(result){
          if(result == 0){
              alert("아이디와 비밀번호를 다시 확인 후 시도해 주세요.");
              return false;
          } else if(result == 9){
              alert("통신 오류");
              return false;  
          } else {
              // 로그인 성공 시
              window.location.href = "/admin/access";
          }
      },
      error : function(jqXHR, status, error){
          alert("알 수 없는 에러 [ " + error + " ]"); 
      }
  });


  
}