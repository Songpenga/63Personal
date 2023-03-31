package com.koreait.restaurant.web.dto;

import lombok.Data;



@Data
public class MenuReqDto {
//    @ApiModelProperty(value = "도서코드", example = "메뉴-999", required = true)
    private String menuCode;

//    @ApiModelProperty(value = "메뉴명", example = "테이스티", required = true)
    private String menuName;

//    @ApiModelProperty(value = "요일", example = "평일")
    private String day;

//    @ApiModelProperty(value = "식사시간", example = "석식")
    private String meals;

//    @ApiModelProperty(value = "대인 가격", example = "20000")
    private int menuAge1;

//    @ApiModelProperty(value = "소인 가격", example = "200000")
    private int menuAge2;

//    @ApiModelProperty(value = "상시/한정", example = "상시")
    private String salesPride;

//    @ApiModelProperty(value = "설명", example = "", required = true)
    private String explanation;

}


