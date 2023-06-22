package com.koreait.restaurant.web.dto.admin;

import lombok.Data;

@Data
public class SearchReservationReqDto {
    private int page;
    private String searchValue;
    private int count;

//    @ApiModelProperty(hidden = true)
    private int index;

    public void setIndex() {
        index = (page - 1) * count;
    }

}
