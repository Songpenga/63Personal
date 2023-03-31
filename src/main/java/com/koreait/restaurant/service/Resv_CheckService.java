package com.koreait.restaurant.service;

import com.koreait.restaurant.entity.DinningMst;
import com.koreait.restaurant.repository.Resv_CheckRepository;
import com.koreait.restaurant.web.dto.CheckReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Resv_CheckService {

    @Autowired
    private Resv_CheckRepository checkRepository;


    public List<DinningMst> searchReserveIdAndNumber(CheckReqDto checkReqDto) {
        System.out.println(checkRepository.searchReserveIdAndNumber(checkReqDto));
        return checkRepository.searchReserveIdAndNumber(checkReqDto);
    }

    public void removeReserve(int reserveId) {
        checkRepository.deleteReserve(reserveId);
    }
}
