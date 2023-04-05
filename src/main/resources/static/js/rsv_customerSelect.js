/* 예약 시간 선택*/
function selectResvTime(value){
  
  var resvTime;
  var resvTimeRange;
    switch(value){
    case 1:
      resvTime = "11:00~14:00";
      resvTimeRange = "중식";
      break;
    case 2:
      resvTime = "14:00~17:00";
      resvTimeRange = "중식";
      break;
    case 3:
      resvTime = "17:00~20:00";
      resvTimeRange = "석식";
      break;
    case 4:
      resvTime = "20:00~22:00";
      resvTimeRange = "석식";
      break;      
    }
    menuObj.meals = resvTimeRange;
    $('#check02').html(resvTime);
}

function checkOnlyOne(element) {
  
  const checkboxes 
      = document.getElementsByName("time");
  
  checkboxes.forEach((cb) => {
    cb.checked = false;
  })
  
  element.checked = true;
}

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

function select_mail(domain){
  console.log(domain);
 
  document.getElementById('email_txt').value = domain;

}