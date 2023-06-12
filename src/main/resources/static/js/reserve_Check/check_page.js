window.onclick = () => {
    ComponentEvent.getInstance().addClickEventLoginButton();
    ComponentEvent.getInstance().addClickEventReserveButton1();
    ComponentEvent.getInstance().addClickEventReserveButton2();
    ComponentEvent.getInstance().addClickEventHomeButton();
}

$(document).ready(function(){
	
	$('.select ul li').click(function(){
		var tab_id = $(this).attr('data-tab');

		$('.select ul li').removeClass('current');
		$('.serve-container').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
	})

});

class ReservePageApi {
	static #instance = null;
	static getInstance() {
		if(this.#instance == null) {
			this.#instance = new ReservePageApi();
		}
		return this.#instance;
	}

    
    check(checkReserve) {
        $.ajax({
            async: false,
            type: "post",
            url: "http://localhost:8000/api/reserve/search/{reserveId}",
            contentType: "application/json",
            data: JSON.stringify(checkReserve),
            dataType: "json",
            success: response => {
                responseData = response.data;
                alert(responseData);
            },
            error: error => {
                console.log(error);
                alert(error);
            }
        });
        return responseData;
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

    addClickEventLoginButton() {
        const loginButton = document.querySelector(".login-button button");

        loginButton.onclick = () => {
            location.href = `http://localhost:8000/admin/login`;
        }
    }
    
    addClickEventReserveButton1() {
        const reserveButton1 = document.querySelector(".reserve-button1");

        reserveButton1.onclick = () => {
            const reserveIdValue1 = document.querySelectorAll(".input-contents")[0].value;
            const numberValue = document.querySelectorAll(".input-contents")[1].value;
            const reserveIdValue2 = document.querySelectorAll(".input-contents")[2].value;
            const reserveNameValue = document.querySelectorAll(".input-contents")[3].value;
       
            const checkReserve = new CheckReserve(reserveIdValue1, numberValue, reserveIdValue2, reserveNameValue);

            if((reserveIdValue1 != null) && (numberValue !=  null)) {
                location.href = `http://localhost:8000/check?reserveId=${reserveIdValue1}&number=${numberValue}`;
            } 
           
            ReservePageApi.getInstance().getReserveNumberPage(checkReserve);

            
        }
    }
    
    addClickEventReserveButton2() {
        const reserveButton2 = document.querySelector(".reserve-button2");
        
        reserveButton2.onclick = () => {
            const reserveIdValue1 = document.querySelectorAll(".input-contents")[0].value;
            const numberValue = document.querySelectorAll(".input-contents")[1].value;
            const reserveIdValue2 = document.querySelectorAll(".input-contents")[2].value;
            const reserveNameValue = document.querySelectorAll(".input-contents")[3].value;
            
            const checkReserve = new CheckReserve(reserveIdValue1, numberValue, reserveIdValue2, reserveNameValue);
            
            if((reserveIdValue2 != null) && (reserveNameValue != null)) {
                location.href = `http://localhost:8000/check?reserveId=${reserveIdValue2}&Name=${reserveNameValue}`;
            }

        }
    }

    addClickEventHomeButton() {
        const homeButton = document.querySelector(".home-button");

        homeButton.onclick = () => {
            location.href = `http://localhost:8000/menulist`;
        }
    }
}

class CheckReserve {
    reserveId = null;
	number = null;
	reserveName = null;

    constructor(reserveId, number, reserveName) {
        this.reserveId = reserveId;
        this.number = number;
        this.reserveName = reserveName;
    }
}
