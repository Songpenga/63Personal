package com.koreait.restaurant.api;

import com.koreait.restaurant.service.ResvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResvApi {

    @Autowired
    private ResvService resvService;
}
