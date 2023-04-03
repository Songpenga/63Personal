package com.koreait.restaurant.web.dto;

import lombok.Data;

@Data
//
public class Resv_SelectMenuDto {
    private int menuCode;
    private String menuName;
    private String day;
    private String meals;
    private int adultPrice;
    private int childPrice;

}
