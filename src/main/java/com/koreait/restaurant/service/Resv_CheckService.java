package com.koreait.restaurant.service;

import com.koreait.restaurant.entity.DinningMst;
import com.koreait.restaurant.repository.Resv_CheckRepository;
import com.koreait.restaurant.web.dto.CheckReqDto;
import com.koreait.restaurant.web.dto.InputReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class Resv_CheckService {

    @Autowired
    private Resv_CheckRepository checkRepository;


    public List<DinningMst> getReserveData(CheckReqDto checkReqDto) {
        System.out.println(checkRepository.getReserveData(checkReqDto));
        return checkRepository.getReserveData(checkReqDto);
    }

    public Map<String, Object> getReservation(String reserveId) {
        Map<String, Object> result = new HashMap<>();
        result.put("dinningMst", checkRepository.findReserveId(reserveId));

        return result;
    }

    public int userInputReserve(InputReqDto inputReqDto) {
        return checkRepository.findUserByReserveCheck(inputReqDto);

    }

    public void modificationReservation(DinningMst dinningMst) {
        checkRepository.reservationUpdateByReserveId(dinningMst);
    }

    public void removeReserve(int reserveId) {
        checkRepository.deleteReserve(reserveId);
    }
}
