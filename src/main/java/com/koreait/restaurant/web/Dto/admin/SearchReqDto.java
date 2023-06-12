package com.koreait.restaurant.web.dto.admin;

import lombok.Data;


@Data
public class SearchReqDto {
    private String searchValue;
    private String order;

    private String limit;

//    @ApiModelProperty(value="페이지 번호", required = false, example = "1")
    private int page;

//    @ApiModelProperty(value="게시글 개수", required = false, example = "20")
    private int count;

//    @ApiModelProperty(hidden = true)
    private int index;

    public void setIndex() {
        index = (page -1) *count;

    }
}
