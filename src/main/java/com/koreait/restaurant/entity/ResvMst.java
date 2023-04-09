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


    private int resvId;

    private String customerName;

    private int resvDate;

    private int resvTime;

    private String resvmenu;

    private int number;

    private String email;

    private int adult;

    private int child;
}
