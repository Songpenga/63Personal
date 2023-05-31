package com.koreait.restaurant.repository.reserve_Check;

import com.koreait.restaurant.web.dto.reserve_Check.SearchResvReqDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Resv_InputRepository {

    public int findUserByReserveCheck(SearchResvReqDto searchResvReqDto);

}


