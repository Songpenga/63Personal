package com.koreait.restaurant.api;

import com.koreait.restaurant.Dto.CMRespDto;
import com.koreait.restaurant.Dto.SelectMenuDto;
import com.koreait.restaurant.repository.SelectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SelectApi {

    @GetMapping("/select")
    public ResponseEntity<CMRespDto<?>> select(SelectMenuDto selectMenuDto){

        return ResponseEntity.ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", null));

    }
}
