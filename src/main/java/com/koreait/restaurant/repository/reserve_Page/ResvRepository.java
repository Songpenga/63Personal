package com.koreait.restaurant.repository.reserve_Page;


import com.koreait.restaurant.web.dto.reserve_Page.ResvDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResvRepository {

    public int saveResv(ResvDto resvDto); //예약하기
}
