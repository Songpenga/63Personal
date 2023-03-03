window.onload = () =>{

}

const MenuObj = {
    menuID: "",

    day: "",
    meals: "",

    adultPrice: "",
    childPrice: ""
}

class SearchApi {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new SearchApi();
        }
        return this.#instance;
    }

    searchBook() {
        let responseData = null;

        $.ajax({
            async: false,
            type: "get",
            url: "http://127.0.0.1:8000/api/search",
            data: MenuObj,
            dataType: "json",
            success: response => {
                responseData = response.data;
            },
            error: error => {
                console.log(error);
            }
        })

        return responseData;
    }

    loadSearchBooks() {
        const responseData = SearchApi.getInstance().searchBook();
        const contentFlex = document.querySelector(".content-flex");

        responseData.forEach(data => {
            contentFlex.innerHTML += `
                <div class="info-container">
                    <div class="book-desc">
                        <div class="img-container">
                            <img src="http://127.0.0.1:8000/image/book/${data.saveName != null ? data.saveName : "no_img.png"}" class="book-img">
                        </div>
                        <div class="like-info"><i class="fa-regular fa-thumbs-up"></i> <span class="like-count">${data.likeCount != null ? data.likeCount : 0}</span></div>
                    </div>
                    
                    <div class="book-info">
                        <div class="book-code">${data.bookCode}</div>
                        <h3 class="book-name">${data.bookName}</h2>
                        <div class="info-text book-author"><b>저자: </b>${data.author}</div>
                        <div class="info-text book-publisher"><b>출판사: </b>${data.publisher}</div>
                        <div class="info-text book-publicationdate"><b>출판일: </b>${data.publicationDate}</div>
                        <div class="info-text book-category"><b>카테고리: </b>${data.category}</div>
                        <div class="book-buttons">
                            <button type="button" class="rental-button">대여하기</button>
                            <button type="button" class="like-button">추천</button>
                        </div>
                    </div>
                </div>
            `;
        })
    }

}