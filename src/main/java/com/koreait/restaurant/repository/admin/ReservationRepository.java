package com.koreait.restaurant.repository.admin;

import com.koreait.restaurant.entity.admin.ReservationMst;
import com.koreait.restaurant.web.dto.admin.ReservationReqDto;
import com.koreait.restaurant.web.dto.admin.SearchNumberListReqDto;
import com.koreait.restaurant.web.dto.admin.SearchReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationRepository {
    public int getReservationTotalCount(SearchNumberListReqDto searchNumberListReqDto);
    public List<ReservationMst> searchReservation(SearchReqDto searchReqDto);

    public ReservationMst findReserveByReserveName(String reserveName);

    public int updateReserveByReserveName(ReservationReqDto reservationReqDto);
    public int maintainUpdateReserveByReserveName(ReservationReqDto reservationReqDto);

}
