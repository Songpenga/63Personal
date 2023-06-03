window.onload = () => {
    MenuListService.getInstance().loadSearchmenu();
    MenuListEvent.getInstance().addClickEventButton();
}

const searchObj = {
    imgId: "",
    titleName: "",
    subMain: "",
    mainMain: "",
    dessert: "",
    price: ""
}

class MenuListApi {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new MenuListApi();
        }
        return this.#instance;
    }

    menulist() {
        let returnData = null;
        $.ajax({
            async: false,
            type: "get",
            url: "http://127.0.0.1:8000/api/admin/main/menus",
            contentType: "application/json",
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
}

class MenuListService {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new MenuListService();
        }
        return this.#instance;
    }

    loadSearchmenu(){
        const responseData = MenuListApi.getInstance().menulist();
        const contentFlex = document.querySelector(".menu");

        console.log(responseData)
        responseData.forEach((data) => {
            contentFlex.innerHTML += `
            <div class="menu-container">                
                    <div class="detail">
                        <h2 class="detail-title"> ${data.titleName} </h2>
                            <ul class="umenu">
                                <li>${data.appetizer}</li>
                                <li>${data.subMain}</li>
                                <li>${data.mainMain}</li>
                                <li>${data.dessert}</li>
                                <br>        
                                <li>${data.price}</li>
                            </ul>
                    </div>                
            </div>     
            `
            
        });
    }
}
                    // <img src="/static/image/kakaofriends.png" class="menu-img"> style="display: none;
class MenuListEvent {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new MenuListEvent();
        }
        return this.#instance;
    }

    addClickEventButton() {
        const reserve = document.querySelector(".resv");
        const reserveCheck = document.querySelector(".reserve-check");

        reserve.onclick = () => {
            location.href = `http://localhost:8000/resv`;
        }

        reserveCheck.onclick = () => {
            location.href = `http://localhost:8000/check/input`;
        }
    }

}


