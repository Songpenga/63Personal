package com.koreait.restaurant.web.Dto;

import lombok.Data;

import java.util.List;

@Data
//
public class SelectMenuDto {
    private int menuCode;
    private String menuName;
    private String day;
    private String meals;
    private int adultPrice;
    private int childPrice;

}
