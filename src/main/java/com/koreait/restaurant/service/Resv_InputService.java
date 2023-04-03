package com.koreait.restaurant.service;

import com.koreait.restaurant.repository.Resv_InputRepository;
import com.koreait.restaurant.web.dto.SearchResvReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Resv_InputService {

    @Autowired
    private Resv_InputRepository inputRepository;

    public int userInputReserve(SearchResvReqDto searchResvReqDto) {
        return inputRepository.findUserByReserveCheck(searchResvReqDto);

    }

}

