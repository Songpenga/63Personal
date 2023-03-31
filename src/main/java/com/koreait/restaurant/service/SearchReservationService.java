package com.koreait.restaurant.service;

import com.koreait.restaurant.entity.admin.SearchReservationMst;
import com.koreait.restaurant.repository.SearchReservationRepository;
import com.koreait.restaurant.web.dto.SearchReservationReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchReservationService {

    private final SearchReservationRepository searchReservationRepository;

    public int getSearchTotalCount(SearchReservationReqDto searchReservationReqDto) {
        return searchReservationRepository.getAdminSearchReservationTotalCount(searchReservationReqDto);
    }

    public List<SearchReservationMst> getSearchReservations(SearchReservationReqDto searchReservationReqDto) {
        searchReservationReqDto.setIndex();
        return searchReservationRepository.adminSearchReservation(searchReservationReqDto);
    }


}