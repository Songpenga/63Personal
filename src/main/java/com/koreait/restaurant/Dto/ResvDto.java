package com.koreait.restaurant.Dto;
//230113
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResvDto {

    //예약번호
    private int resvId;
    //예약자이름
    private String customerName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime resvDate; // 예약날짜

    private int resvTime; //예약시간

    private String resvmenu; //예약메뉴

    private int number; //연락처

    private String email;

    private int adult;

    private int child;

    private String guest;

    private int menu;
}
