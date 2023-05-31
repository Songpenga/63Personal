package com.koreait.restaurant.web.dto.reserve_Main_Update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateUseReqDto {

    private String reserveId;

    private String reserveDate;
    private String reserveTime;
    private int adult;
    private int child;


}
