package com.koreait.restaurant.entity.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ReservationMst {

//    @ApiModelProperty
    private int reserveId;

//    @ApiModelProperty(value = "예약자", example = "김민지", required = true)
//    @NotBlank
    public String reserveName;

//    @ApiModelProperty(value = "예약요일", example = "금요일", required = true)
//    @NotBlank
    public String reserveDate;

//    @ApiModelProperty(value = "예약시간", example = "17시", required = true)
//    @NotBlank
    public String reserveTime;

//    @ApiModelProperty(value = "이메일", example = "aaa@gmail.com", required = true)
//    @NotBlank
    public String number;

//    @ApiModelProperty(value = "이메일", example = "aaa@gmail.com", required = true)
//    @NotBlank
    public String email;

//    @ApiModelProperty(value = "대인 수", example = "3", required = true)
//    @NotBlank
    public int adult;

//    @ApiModelProperty(value = "소인 수", example = "2", required = true)
//    @NotBlank
    public int child;

//    @ApiModelProperty(value = "총 인원수", example = "5", required = true)
//    @NotBlank
    public int guest;

//    @ApiModelProperty(value = "요청사항", example = "null", required = true)
//    @NotBlank
    public String request;
}
