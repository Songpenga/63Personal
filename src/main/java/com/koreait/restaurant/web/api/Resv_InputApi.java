package com.koreait.restaurant.web.api;

import com.koreait.restaurant.service.Resv_InputService;
import com.koreait.restaurant.web.dto.CMRespDto;
import com.koreait.restaurant.web.dto.SearchResvReqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/reserve")
public class Resv_InputApi {

    @Autowired
    private Resv_InputService inputService;

    @PostMapping("/input/{reserveId}")
    public ResponseEntity<?> getCheckInput(@RequestBody SearchResvReqDto searchResvReqDto) {

        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", inputService.userInputReserve(searchResvReqDto)));
    }

}