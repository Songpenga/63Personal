package com.koreait.restaurant.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SelectMenu {
    private int menuId; //메뉴코드
    private String menuName; // 코스
    private String day; // 점심, 저녁
    private String meals; // 주중, 주말

}
