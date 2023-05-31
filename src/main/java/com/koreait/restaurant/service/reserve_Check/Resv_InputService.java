package com.koreait.restaurant.service.reserve_Check;

import com.koreait.restaurant.repository.reserve_Check.Resv_InputRepository;
import com.koreait.restaurant.web.dto.reserve_Check.SearchResvReqDto;
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

