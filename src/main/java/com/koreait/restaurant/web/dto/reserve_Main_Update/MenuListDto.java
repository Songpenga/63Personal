package com.koreait.restaurant.web.dto.reserve_Main_Update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuListDto {

    private int imgId;
    private String titleName;
    private String appetizer;
    private String subMain;
    private String mainMain;
    private String dessert;
    private int price;
}
