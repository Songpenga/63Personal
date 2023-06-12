
package com.koreait.restaurant.repository.admin;

import com.koreait.restaurant.entity.admin.SearchReservationMst;
import com.koreait.restaurant.web.dto.admin.SearchReservationReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchReservationRepository {
    public int getAdminSearchReservationTotalCount(SearchReservationReqDto searchReservationReqDto);
    public List<SearchReservationMst> adminSearchReservation(SearchReservationReqDto searchReservationReqDto);
}