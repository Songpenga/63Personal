window.onload = () => {

    updateEvent.getInstance().addEventClickButton();

}

const UserObj = {
    reserveId: "", 
    reserveName: "",
    reserveDate: "",
    reserveTime: "",
    number: "",
    email: "",
    adult: "",
    child: "",
    guest: "",
    request: "",
    menu: ""
}



class updateApi {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new updateApi();
        }
        return this.#instance;
    }
    modifyUser() {
        let successFlag = false;
        $.ajax({
            async: false,
            type: "put",
            url: `http://localhost:8000/api/user/${UserObj.reserveId}`,
            contentType: "application/json",
            data: JSON.stringify(UserObj),
            dataType: "json",
            success: response => {
                successFlag = true;
            },
            error: error => {
                console.log(error);
            } 

        });
        return successFlag;
    }

    getUser() {
        let successFlag = false;
        $.ajax({
            async: false,
            type: "get",
            url: "http://localhost:8000/api/searchuser",
            // contentType: "application/json",
            // data: JSON.stringify(UserObj),
            dataType: "json",
            success: response => {
                successFlag = true;
                console.log(response);
            },
            error: error => {
                console.log(error);
            }
        });
        return successFlag;
    }
}

class updateService {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new updateService();
        }
        return this.#instance;
    }

    loadUserService() {
        
        const getContent = document.querySelectorAll(".modification-input");
        const reserveDate = updateApi.getInstance().getUser();
      
        console.log(getContent);

    }
}
class updateEvent {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new updateEvent();
        }
        return this.#instance;
    }

    addEventClickButton() {
        const rentalButton = document.querySelector(".reserve-submitt");
            rentalButton.onclick = () => {
                const readButton = updateApi.getInstance().getUser();
                updateService.getInstance().loadUserService();
                console.log(readButton);
            }
    } 
}