package com.koreait.restaurant.web.controller;

import com.koreait.restaurant.service.ResvService;

import com.koreait.restaurant.web.dto.ResvDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payment")
public class VerifyController {

    @Autowired
    private ResvService resvService;

    @PostMapping("/complete")
    public @ResponseBody void complete(@RequestBody ResvDto resvDto, BindingResult bindingResult){
        resvService.registerBook(resvDto);
    }


}