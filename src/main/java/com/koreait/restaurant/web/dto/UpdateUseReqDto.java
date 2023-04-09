package com.koreait.restaurant.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUseReqDto {
    private String reserveId;
    private String reserveDate;
    private String reserveTime;

    private int adult;
    private int child;
}
