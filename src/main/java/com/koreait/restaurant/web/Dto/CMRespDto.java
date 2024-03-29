package com.koreait.restaurant.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class CMRespDto<T>{

    private int code;
    private String message;
    private T data;
}


