package com.koreait.restaurant.entity.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationMst {

    private int reserveId;

    public String reserveName;

    public String reserveDate;

    public String reserveTime;

    public String number;

    public String email;

    public int adult;

    public int child;

    public int guest;

    public String request;
}
