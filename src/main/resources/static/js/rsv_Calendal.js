const menuObj = {
    day: null,
    meals: null
}

function prevMonth(date) {
    var target = new Date(date);
    target.setDate(1);
    target.setMonth(target.getMonth() - 1);

    return getYmd(target);
}

function nextMonth(date) {
    var target = new Date(date);
    target.setDate(1);
    target.setMonth(target.getMonth() + 1);

    return getYmd(target);
}

function getYmd(target) {
    // IE에서 날짜 문자열에 0이 없으면 인식 못함
    var month = ('0' + (target.getMonth() + 1)).slice(-2);
    return [target.getFullYear(), month, '01'].join('-');
}

function fullDays(date) {
    var target = new Date(date);
    var year = target.getFullYear();
    var month = target.getMonth();

    var firstWeekDay = new Date(year, month, 1).getDay();
    var thisDays = new Date(year, month + 1, 0).getDate();

    // 월 표시 달력이 가지는 셀 갯수는 3가지 가운데 하나이다.
    // var cell = [28, 35, 42].filter(n => n >= (firstWeekDay + thisDays)).shift();
    var cell = [28, 35, 42].filter(function (n) {
            return n >= (firstWeekDay + thisDays);
        }).shift();

    // 셀 초기화, IE에서 Array.fill()을 지원하지 않아서 변경
    // var days = new Array(cell).fill({date: '', dayNum: '', today: false});
    var days = []
    for (var i = 0; i < cell; i++) {
        days[i] = {
            date: '',
            dayNum: '',
            today: false
        };
    }
    
    var now = new Date();
    var today = new Date(now.getFullYear(), now.getMonth(), now.getDate());
    var inDate;
    for (var index = firstWeekDay, i = 1; i <= thisDays; index++, i++) {
        inDate = new Date(year, month, i);
        days[index] = {
            date: i,
            dayNum: inDate.getDay(),
            today: (inDate.getTime() === today.getTime())
        };
    }

    return days;
}

function drawMonth(date) {
    $('#month-this').text(date.substring(0, 7).replace('-', '.'));
    $('#month-prev').data('ym', prevMonth(date));
    $('#month-next').data('ym', nextMonth(date));

    $('#tbl-month').empty();

    var td = '<td class="__REST__ __TODAY__"><a __HREF__>__DATE__</a></td>';
    var href = '/depart/schedule?date=' + date.substring(0, 8);
    var hasEvent;
    var tdClass;
    var week = null;
    var days = fullDays(date);

}


function drawMonth(date) {
    $('#month-this').text(date.substring(0, 7).replace('-', '.'));
    $('#month-prev').data('ym', prevMonth(date));
    $('#month-next').data('ym', nextMonth(date));

    $('#tbl-month').empty();

    var td = '<td class="__REST__ __TODAY__"><a __HREF__>__DATE__</a></td>';
    var href = '/depart/schedule?date=' + date.substring(0, 8);
    var hasEvent;
    var tdClass;
    var week = null;
    var days = fullDays(date);
    for (var i = 0, length = days.length; i < length; i += 7) {
        // 전체 셀을 주단위로 잘라서 사용
        week = days.slice(i, i + 7);
        
        var $tr = $('<tr></tr>');
        week.forEach(function (obj, index) {
            
            hasEvent = (index === 3);
            tdClass = (index === 0)? 'sun': '';
            tdClass = (index === 6)? 'sat': tdClass;

            $tr.append(td.replace('__REST__', tdClass)
                        .replace('__TODAY__', (obj['today'])? 'today': '')                       
                        .replace('__DATE__', obj['date']));
        });
        $('#tbl-month').append($tr);
    }
}



$(function () {
    var date = (new Date()).toISOString().substring(0, 10);
    drawMonth(date);

    $('.month-move').on('click', function (e) {
        e.preventDefault();

        drawMonth($(this).data('ym'));
    });
});


/* ============= 달력 클릭 EVENT  ============= */ 

$("#resvMon").on("click", "td", function () {
    var week = new Array('일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일');

    var today = new Date();
    var clickedYear = today.getFullYear();
    var clickedMonth = ( 1 + today.getMonth() );      
    var td = $(this);

    var date = new Date(Number(clickedYear), Number(clickedMonth)-1, Number(td.text()));
    var today_week = week[date.getDay()];
    
    console.log("클릭한 td year :" + clickedYear);
    console.log("클릭한 td month :" + clickedMonth);
    console.log("클릭한 td 값 :" + td.text());
    console.log(date, today_week);
    const weekList = ["토요일", "일요일"];
    menuObj.day = weekList.includes(today_week) ? "주말" : "평일";

    $("#check01").html(clickedYear + "년" + clickedMonth + "월" + td.text() + "일");
    resvObj.resvDate = clickedYear + "-" + clickedMonth + "-" + td.text();
    
 });

 
