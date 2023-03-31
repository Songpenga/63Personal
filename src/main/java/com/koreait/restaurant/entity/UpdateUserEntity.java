package com.koreait.restaurant.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateUserEntity {

    private int reserveId;
    private String reserveName;
    private String reserveDate;
    private String reserveTime;
    private String number;
    private String email;
    private int adult;
    private int child;
    private String guest;
    private String request;
    private String menu;
}
