package com.koreait.restaurant.web.dto;

import lombok.Data;


@Data
public class ResvDto {

    private int resvId; //예약번호

    private String customerName;  //예약자이름

    private String resvDate; // 예약날짜

    private String resvTime; //예약시간

    private String resvmenu; //예약메뉴

    private String number; //연락처

    private String email;

    private int adult;

    private int child;

    private String guest;

    private String request;
}
