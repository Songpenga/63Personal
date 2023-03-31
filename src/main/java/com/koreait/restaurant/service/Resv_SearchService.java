package com.koreait.restaurant.service;

import com.koreait.restaurant.repository.Resv_SearchRepository;
import com.koreait.restaurant.web.dto.SearchResvReqDto;
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

