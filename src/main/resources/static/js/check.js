window.onload = () => {
	CheckService.getInstance().loadReserveData();
	ComponentEvent.getInstance().addHomeButtonClickEvent();
	ComponentEvent.getInstance().addClickEventmodification();
	ComponentEvent.getInstance().addClickEventDeleteButton();
}

const URLSearch = new URLSearchParams(location.search);

const homeScroll = document.querySelector("#home");
const homeHeight = homeScroll.getBoundingClientRect().height;

	/*modification.html으로 넘겨주는 값 -> 120번째줄로 이동*/
const sendcheckObj={
    reserveId : null,
    number : null
}

document.addEventListener('scroll', () => {
   if (window.scrollY > homeHeight) {
      homeScroll.classList.add('active');
   } else {
      homeScroll.classList.remove('active');
   }
});

class CheckApi {
	static #instance = null;
	static getInstance() {
		if(this.#instance == null) {
			this.#instance = new CheckApi();
		}
		return this.#instance;
	}

	getReserveData() {
		let returnData = null;

		$.ajax({
			async: false,
			type: "get",
			url: "http://localhost:8000/api/check",
			data: {
				reserveId : URLSearch.get("reserveId"),
				number : URLSearch.get("number"),
				reserveName : URLSearch.get("reserveName")

			},
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

	reserveDataDeleteRequest(reserveId) {
        $.ajax({
            async: false,
            type: "delete",
            url: "http://localhost:8000/api/check/" + reserveId,
            dataType: "json",
            success: (response) => {
                alert("예약 취소가 완료 되었습니다.");

            },
            error: (error) => {
                alert("예약 취소가 실패 되었습니다. 관리자에게 문의하세요.");
                console.log(error);
            }
        });
    }


}

class CheckService{
	static #instance = null;
	static getInstance() {
		if(this.#instance == null) {
			this.#instance = new CheckService();
		}
		return this.#instance;
	}

	loadReserveData() {
		const responseData = CheckApi.getInstance().getReserveData();

		const reserveContents1 = document.querySelector(".reserve-contents1 tbody");
		const reserveContents2 = document.querySelector(".reserve-contents2 tbody");
		const reserveContents3 = document.querySelector(".reserve-contents3 tbody");
		const reserveContents4 = document.querySelector(".reserve-contents4 tbody");


		responseData.forEach(data => {
			reserveContents1.innerHTML += `
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

			/*localStorage.setItem 에 JSON으로 값 저장 -> modification.js로 이동*/
			sendcheckObj.reserveId = data.reserveId;
			sendcheckObj.number = data.number;
			localStorage.setItem('sendcheckObj', JSON.stringify(sendcheckObj));


			console.log(sendcheckObj);
		});
		responseData.forEach(data => {
			reserveContents2.innerHTML += `
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
		responseData.forEach(data => {
			reserveContents3.innerHTML += `
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
		responseData.forEach(data => {
			reserveContents4.innerHTML += `
			<tr>
				<td>${data.request}</td>
			</tr>
			`;
		});
	}

}

class ComponentEvent {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new ComponentEvent();
        }
        return this.#instance;
    }

	addHomeButtonClickEvent() {
        const homeButton = document.querySelector(".home-button");

        homeButton.onclick = () => {
            location.href = `http://localhost:8000/menulist`;
        }
    }

	addClickEventmodification() {
		const changeButton = document.querySelector(".change-button");

		changeButton.onclick = () => {
			location.href = `http://localhost:8000/reservation/modification`;
		}
	}

	addClickEventDeleteButton() {
		const deleteButton = document.querySelector(".delete-button");

		const url = location.search;

		deleteButton.onclick = () => {

			let urlParams = new URLSearchParams(url);
			let reserveId = urlParams.get('reserveId')

			localStorage.removeItem(reserveId)

			CheckApi.getInstance().reserveDataDeleteRequest(reserveId);

		}
	}



}
