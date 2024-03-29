package com.koreait.restaurant.service.reserve_Check;

import com.koreait.restaurant.entity.DinningMst;
import com.koreait.restaurant.repository.reserve_Check.Resv_CheckRepository;
import com.koreait.restaurant.web.dto.reserve_Check.CheckReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Resv_CheckService {

    @Autowired
    private Resv_CheckRepository checkRepository;


    public List<DinningMst> getReserveData(CheckReqDto checkReqDto) {
        System.out.println(checkRepository.getReserveData(checkReqDto));
        return checkRepository.getReserveData(checkReqDto);
    }

    public void removeReserve(int reserveId) {
        checkRepository.deleteReserve(reserveId);
    }
}
