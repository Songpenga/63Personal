window.onload = () =>{
  SelectComponent.getInstance().addClickEventResvSelect();
}

class SearchApi {
  static #instance = null;
  static getInstance() {
      if(this.#instance == null) {
          this.#instance = new SearchApi();
      }
      return this.#instance;
  }

  searchMenu() {
      let responseData = null;

      $.ajax({
          async: false,
          type: "get",
          url: "http://127.0.0.1:8000/api/search",
          data: menuObj, //day(평일,주말) && meals(점심,저녁)
          // date가 없어지니까 성공됨... 왜지..? -> 값을 가져와야하는데 쓸데없이 값을 전달해서
          dataType: 'json',
          success: response => {
              responseData = response.data;
          },
          error: error => {
              console.log(error);
          }
      });

      return responseData;
  }

  getCategories() {
    let returnData = null;

    $.ajax({
        async: false,
        type: "get",
        url: "http://localhost:8000/api/select",
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

class SearchService {
  static #instance = null;
  static getInstance() {
      if(this.#instance == null) {
          this.#instance = new SearchService();
      }
      return this.#instance;
  }

  loadCategories(){
    const categoryList = document.querySelector(".categoriy-list");
  }

  loadMenuList() {
      const responseData = SearchApi.getInstance().searchMenu();
      const contentFlex = document.querySelector(".resv_menu_test");

      console.log(responseData);

      responseData.forEach(data => {
          contentFlex.innerHTML = `
          <div class="menu_select">
            <input
              type="radio"
              id="${data.day}${data.meals}"
              class="ckbCheck"
              name="ckbCheck"
              value="${data.adultPrice}"
              
            />
  
            <label class="la_check" for="${data.day}${data.meals}">${data.day}${data.meals}</label>
            <span class="img">
              <img
                width="180"
                height="126"
                src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJYAAADICAMAAAA9W+hXAAAAA1BMVEUYOh3z4H2yAAAANElEQVR4nO3BMQEAAADCoPVP7WsIoAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAeAN1+AABVhDU2QAAAABJRU5ErkJggg=="
                alt="배너"
              />
            </span>
            <div class="bx_price">
              <div class="price_info">
                <p class="price">
                  <span>대인</span>
                  <span class="mem_num">${data.adultPrice}</span>
                </p>
  
                <p class="price">
                  <span>소인</span>
                  <span class="mem_num">${data.childPrice}</span>
                </p>
              </div>
            </div>
  
            <a href="#" class="btn_more href_link"></a>
            <div
              id="layer_type02"
              class="menu_sel clfix rv_layer_type02 lay_i1"
              style="display: none"
            >
              <div class="width:826px;height:264px;background-color:#FFFFFF">
                <span style="width: 377px; height: 264px; float: left"></span>
              </div>
            </div>
          </div>
          `;
      })       
  }

  checkMenuPrice(){
    const responseData = SearchApi.getInstance().searchMenu();
    var count_adult = document.getElementById("count01").innerText;
    var count_child = document.getElementById("count02").innerText;
    //const PriceSum = document.getElementById("price").value;

    console.log(count_adult);
    console.log(count_child);

    responseData.forEach(data => {
    
      var adultCheckPrice = Number(data.adultPrice);
      var childCheckPrice = Number(data.childPrice);

      var adultPrice = Number(count_adult);
      var childPrice = Number(count_child);

      var checkSumAdult = adultCheckPrice * adultPrice;
      var checkSumChild = childCheckPrice * childPrice;
      
      console.log(checkSumAdult);
      console.log(checkSumChild);
      
      document.getElementById("price").innerText = checkSumAdult + checkSumChild;
      resvObj.amount = checkSumAdult + checkSumChild;
      // ImportApi.getInstance().importPayParams.amount =  checkSumAdult + checkSumChild;

    });
    
  }


}

class SelectComponent{
static #instance = null;
static getInstance(){
  if(this.#instance == null){
    this.#instance = new SelectComponent();
  }
  return this.#instance;
}

  addClickEventResvSelect() {
    const resvTimeButton = document.querySelector(".resvTimeButton");

    resvTimeButton.onclick = () => {
      SearchService.getInstance().loadMenuList();
      SearchService.getInstance().checkMenuPrice();
    }

  }
}