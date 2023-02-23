//사용자가 선택한 객체 저장

function funcAddMenuChecked() {
  var listVar = $('input[name="ckbCheck"]:checked').val();
  console.log(listVar);

  // $('input[name="ckbCheck"]').removeAttr('checked');
}
