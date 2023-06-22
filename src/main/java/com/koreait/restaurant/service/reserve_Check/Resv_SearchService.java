package com.koreait.restaurant.service.reserve_Check;

import com.koreait.restaurant.repository.reserve_Check.Resv_SearchRepository;
import com.koreait.restaurant.web.dto.reserve_Check.SearchResvReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Resv_SearchService {

    @Autowired
    private Resv_SearchRepository searchRepository;

    public int userSearchReserve(SearchResvReqDto searchResvReqDto) {
        return searchRepository.findUserByReserveCheck(searchResvReqDto);

    }

}

