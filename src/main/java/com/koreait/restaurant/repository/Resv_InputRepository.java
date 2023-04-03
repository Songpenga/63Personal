package com.koreait.restaurant.repository;

import com.koreait.restaurant.web.dto.SearchResvReqDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Resv_InputRepository {

    public int findUserByReserveCheck(SearchResvReqDto searchResvReqDto);

}


