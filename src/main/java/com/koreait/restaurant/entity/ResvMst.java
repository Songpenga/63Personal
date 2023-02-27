package com.koreait.restaurant.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResvMst {

    //예약번호
    private int resvId;
    //예약자이름
    private String customerName;

    private int resvDate; // 예약날짜

    private int resvTime; //예약시간

    private String resvmenu; //예약메뉴

    private int number;

    private String email;

    private int adult;

    private int child;
}
