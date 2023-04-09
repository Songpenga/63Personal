window.onload = () => {
	/*localStorage getItem으로 전달값 확인*/
    console.log(JSON.parse(localStorage.getItem('sendcheckObj'))); 
	
	checkReserveEvent.getInstance().loadCheckData();
	ReservationModificationService.getInstance().loadModifyValue();
}

/* localStorage.getItem 으로 오는 값을 받음 */
let checkObj={
    reserveId : null,
    number : null
}

/*update setting value*/
const Modifyvalue = {
	date : "",
	time : "",
	adult : "",
	child : "",
	resquest : ""
}

/*localStorage.setItem에서 준 값을 localStorage.getItem 으로 오는 값을 받음 -> 39, 126줄로 이동*/
checkObj = JSON.parse(localStorage.getItem('sendcheckObj'));
console.log(checkObj);


class ModificationApi {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new ModificationApi();
        }
        return this.#instance;
    }

	/*localStorage.getItem로 받아온
	예약번호, 이름을 기준으로 
	예약자 정보를 가져옴 -> 130줄로 이동*/
	Modify_getReserveData() {
		let returnData = null;

		$.ajax({
			async: false,
			type: "get",
			url: "http://localhost:8000/api/check",
			data: checkObj,
			dataType: "json",
			success: response => {
				console.log(response);
                returnData = response.data;
			},
			error: error => {
				console.log(error);
			}
		});

		return returnData;
	}

	modifyReserveInfo(){
		let successFlag = false;

        $.ajax({
            async: false,
            type: "put",
            url: `http://localhost:8000/api/user/${checkObj.reserveId}`,
            contentType: "application/json",
            data: JSON.stringify(checkObj),
            dataType: "json",
            success: response => {
                console.log(response);
                successFlag = true;
            },
            error: error => {
                console.log(error);
            }
        });

        return successFlag;
	}
}

class ReservationModificationService {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new ReservationModificationService();
        }
        return this.#instance;
    }

	/* 
		변경할 정보가 잠긴 selecte옵션, Date 값을 가져온다.
	*/
	setModifyValue(){

		const modifytime = document.getElementById('timeSelect');
		const modifyadult = document.getElementById('adultSelect');
		const modifychild = document.getElementById('childSelect');

		Modifyvalue.date = document.getElementById('dateSelect').value;
		Modifyvalue.time = modifytime.options[modifytime.selectedIndex].text;
		Modifyvalue.adult = modifyadult.options[modifyadult.selectedIndex].text;
		Modifyvalue.child = modifychild.options[modifychild.selectedIndex].text;
		Modifyvalue.resquest = document.querySelector('.modification-input-request').value;


	}

	/* 
		예약변경 버튼을 누르면 console로 변경할 값을 확인할수있다.
	*/
	loadModifyValue(){
		var loadSetValue = document.querySelector('.modification-button');
		loadSetValue.onclick = () => {
			ReservationModificationService.getInstance().setModifyValue()
			console.log(Modifyvalue);
		}
	}
    
}

class checkReserveEvent {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new checkReserveEvent();
        }
        return this.#instance;
    }

	/*
	ModificationApi.getInstance().Modify_getReserveData()으로
	checkObj에 맞는 예약자 정보를 불러옴
	*/
    loadCheckData(){
		const checkData = ModificationApi.getInstance().Modify_getReserveData();
		const checkContents1 = document.querySelector(".reserve-contents1 tbody");
		const checkContents2 = document.querySelector(".reserve-contents2 tbody");
		const checkContents3 = document.querySelector(".reserve-contents3 tbody");
		const checkContents4 = document.querySelector(".reserve-contents4 tbody");
		console.log(localStorage.getItem('checkObj'));

        console.log(checkData);
		checkData.forEach(data => {
			checkContents1.innerHTML += `
				<tr>                       
					<th>성명(한글)</th>
					<td>${data.reserveName}</td> 
				</tr>
				<tr>                       
					<th>예약번호</th>
					<td class="reserve-id">${data.reserveId}</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>${data.number}</td>
				</tr>        
				<tr>
					<th>이메일</th>
					<td>${data.email}</td>
				</tr>  
			`;
		});

		checkData.forEach(data => {
			checkContents2.innerHTML += `
			<tr>                       
				<th>예약일</th> 
				<td>${data.reserveDate}</td>
			</tr>
			<tr>
				<th>예약시간</th>
				<td>${data.reserveTime}</td>
			</tr>
		`;
		});
		checkData.forEach(data => {
			checkContents3.innerHTML += `
				<tr> 
					<th>대인</th>
					<td>${data.adult}명</td>
				</tr>
				<tr>
					<th>소인</th>
					<td>${data.child}명</td>
				</tr>
			`;
		});
		checkData.forEach(data => {
			document.querySelector('.modification-input-request').value = data.request;

		});
    }

}