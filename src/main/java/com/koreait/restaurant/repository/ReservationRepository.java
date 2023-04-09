package com.koreait.restaurant.repository;

import com.koreait.restaurant.entity.admin.ReservationMst;
import com.koreait.restaurant.web.dto.ReservationReqDto;
import com.koreait.restaurant.web.dto.SearchNumberListReqDto;
import com.koreait.restaurant.web.dto.SearchReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//admin
@Mapper
public interface ReservationRepository {
    public int getReservationTotalCount(SearchNumberListReqDto searchNumberListReqDto);
    public List<ReservationMst> searchReservation(SearchReqDto searchReqDto);

    public ReservationMst findReserveByReserveName(String reserveName);

    public int updateReserveByReserveName(ReservationReqDto reservationReqDto);
    public int maintainUpdateReserveByReserveName(ReservationReqDto reservationReqDto);

}
