package com.koreait.restaurant.entity.admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SearchMenuMst {
    private String menuCode;
    private String menuName;
    private String day;
    private String meals;
    private String menuAge1;
    private String menuAge2;
    private String salesPride;
//    private String saveName;

}