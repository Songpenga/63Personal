package com.koreait.restaurant.web.api;

import com.koreait.restaurant.entity.DinningMst;
import com.koreait.restaurant.service.Resv_CheckService;
import com.koreait.restaurant.web.dto.CMRespDto;
import com.koreait.restaurant.web.dto.CheckReqDto;
import com.koreait.restaurant.web.dto.InputReqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/check")
public class Resv_CheckApi {

    @Autowired
    private Resv_CheckService checkService;

    @GetMapping("")
    public ResponseEntity<CMRespDto<List<DinningMst>>> getReserveData(CheckReqDto checkReqDto) {
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", checkService.getReserveData(checkReqDto)));

    }

    @PostMapping("/input/{reserveId}")
    public ResponseEntity<?> getCheckInput(@RequestBody InputReqDto inputReqDto) {

        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", checkService.userInputReserve(inputReqDto)));
    }

    @GetMapping("/reservation/modification/{reserveId}")
    public ResponseEntity<CMRespDto<Map<String, Object>>> getReservationData(@PathVariable String reserveId) {

        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", checkService.getReservation(reserveId)));
    }

    @PutMapping("/{reserveId}")
    public ResponseEntity<CMRespDto<?>> modifyReservation(@PathVariable int reserveId, @RequestBody DinningMst dinningMst) {
        checkService.modificationReservation(dinningMst);
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", true));
    }

    @DeleteMapping("/{reserveId}")
    public ResponseEntity<CMRespDto<?>> removeReserve(@PathVariable int reserveId) {
        checkService.removeReserve(reserveId);
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", true));
    }

}
