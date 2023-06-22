package com.koreait.restaurant.web.api.reserve_Page;

import com.koreait.restaurant.web.dto.reserve_Page.ResvDto;
import com.koreait.restaurant.aop.annotation.ParamsAspect;
import com.koreait.restaurant.aop.annotation.ValidAspect;
import com.koreait.restaurant.service.reserve_Page.ResvService;
import com.koreait.restaurant.web.dto.CMRespDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api")
@RestController
public class ResvApi {

    @Autowired
    private ResvService resvService;

    @ParamsAspect
    @ValidAspect
    @PostMapping("/resv")
    public ResponseEntity<CMRespDto<?>> registerBook(@RequestBody ResvDto resvDto, BindingResult bindingResult) {
        resvService.registerBook(resvDto);
        return ResponseEntity
                .created(null)
                .body(new CMRespDto<>(HttpStatus.CREATED.value(), "Successfully", true));
    }

}
