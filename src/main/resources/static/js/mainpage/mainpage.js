window.onload = () => {
    MenuListService.getInstance().loadSearchmenu();

}
let searchObj = {
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
            // contentType: "application/json",
            // data: searchObj,
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
        const contentFlex = document.querySelector(".menu01");

        console.log(responseData)
        responseData.forEach((data) => {
            contentFlex.innerHTML += `
            <div class="menu01">
                <div class="img-container">
                    <img src="/static/image/kakaofriends.png" class="menu-img">
                    <button class="menu-button1" id="menu-button1">메뉴보기</button>
                    <div class="content-flex-test detail" style="display: none;">
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
            </div>     
            `
            
        });
    }
}

class MenuListEvent{
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new MenuListEvent();
        }
        return this.#instance;
    }

    addClickEventButton() {
        
    }

}


