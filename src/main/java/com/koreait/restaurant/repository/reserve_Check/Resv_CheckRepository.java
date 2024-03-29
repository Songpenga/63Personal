package com.koreait.restaurant.repository.reserve_Check;

import com.koreait.restaurant.entity.DinningMst;
import com.koreait.restaurant.web.dto.reserve_Check.CheckReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Resv_CheckRepository {


   public List<DinningMst> getReserveData(CheckReqDto searchReqDto);

   public int saveReserveCheck(CheckReqDto searchReqDto);

   public int deleteReserve(int reserveId);

}
