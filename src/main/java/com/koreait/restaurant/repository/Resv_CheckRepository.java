package com.koreait.restaurant.repository;

import com.koreait.restaurant.entity.DinningMst;
import com.koreait.restaurant.web.dto.CheckReqDto;
import com.koreait.restaurant.web.dto.InputReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Resv_CheckRepository {


   public List<DinningMst> getReserveData(CheckReqDto checkReqDto);

   public DinningMst findReserveId(String reserveId);

   public int saveReserveCheck(CheckReqDto checkReqDto);

   public int findUserByReserveCheck(InputReqDto inputReqDto);

   public int reservationUpdateByReserveId(DinningMst dinningMst);

   public int deleteReserve(int reserveId);


}
