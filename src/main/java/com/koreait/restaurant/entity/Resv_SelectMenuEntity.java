package com.koreait.restaurant.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Resv_SelectMenuEntity {

    private int menuCode;
    private String menuName;
    private String day;
    private String meals;
    private int adultPrice;
    private int childPrice;

}
