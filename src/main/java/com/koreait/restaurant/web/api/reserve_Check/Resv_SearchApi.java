package com.koreait.restaurant.web.api.reserve_Check;

import com.koreait.restaurant.service.reserve_Check.Resv_SearchService;
import com.koreait.restaurant.web.dto.CMRespDto;
import com.koreait.restaurant.web.dto.reserve_Check.SearchResvReqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/reserve")
public class Resv_SearchApi {

    @Autowired
    private Resv_SearchService reserveService;

    @PostMapping("/search/{reserveId}")
    public ResponseEntity<?> getCheckPage(@RequestBody SearchResvReqDto searchResvReqDto) {

        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", reserveService.userSearchReserve(searchResvReqDto)));
    }

}