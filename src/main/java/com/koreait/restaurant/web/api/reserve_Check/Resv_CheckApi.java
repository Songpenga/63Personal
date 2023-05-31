package com.koreait.restaurant.web.api.reserve_Check;

import com.koreait.restaurant.entity.DinningMst;
import com.koreait.restaurant.service.reserve_Check.Resv_CheckService;
import com.koreait.restaurant.web.dto.CMRespDto;
import com.koreait.restaurant.web.dto.reserve_Check.CheckReqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class Resv_CheckApi {

    @Autowired
    private Resv_CheckService checkService;

    @GetMapping("/check")
    public ResponseEntity<CMRespDto<List<DinningMst>>> getReserveData(CheckReqDto checkReqDto) {
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", checkService.getReserveData(checkReqDto)));

    }

    @DeleteMapping("/check/{reserveId}")
    public ResponseEntity<CMRespDto<?>> removeReserve(@PathVariable int reserveId) {
        checkService.removeReserve(reserveId);
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", true));
    }


}
