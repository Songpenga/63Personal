package com.koreait.restaurant.repository;


import com.koreait.restaurant.web.dto.ResvDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResvRepository {

    public int saveResv(ResvDto resvDto); //예약하기
}
