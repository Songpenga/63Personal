package com.koreait.restaurant.repository;

import com.koreait.restaurant.web.dto.SearchResvReqDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Resv_SearchRepository {

    public int findUserByReserveCheck(SearchResvReqDto searchResvReqDto);

}


