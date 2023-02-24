/* 인원 선택 */
function countRsvAdult(type){

  var count_per_adult = document.getElementById("count01");
  var check_03 = document.getElementById("check03");
  var sumPerson;
  let number_adult = count_per_adult.innerText;

    if(type == 'plus'){
      number_adult = parseInt(number_adult) + 1;
      sumPerson = parseInt(check_03.innerText)+1;
    } else if(type == 'minus'&& number_adult>0){
      number_adult = parseInt(number_adult) - 1;
      sumPerson = parseInt(check_03.innerText)-1;
    }
  
    count_per_adult.innerText = number_adult;  
  $('#check03').html(sumPerson);

}

function countRsvChild(type){

  var count_per_child = document.getElementById("count02")
  var check_03 = document.getElementById("check03");
  var sumPerson;

  let number_child = count_per_child.innerText;

  if(type == 'plus'){
    number_child = parseInt(number_child) + 1;
    sumPerson = parseInt(check_03.innerText)+1;
  } else if(type == 'minus' && number_child>0){
    number_child = parseInt(number_child) - 1;
    sumPerson = parseInt(check_03.innerText)-1;
  }

  count_per_child.innerText = number_child;
  $('#check03').html(sumPerson);
}



/* 메뉴 값 선택 */
function funcAddMenuChecked() {
  var listVar = $('input[name="ckbCheck"]:checked').val();
  var listText = $('input[name="ckbCheck"]:checked').prop("id");
  // var check_04 = document.getElementById("check04");
  console.log(listVar);

  $('#check04').html(listText);
}

