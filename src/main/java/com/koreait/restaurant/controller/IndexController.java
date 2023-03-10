package com.koreait.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class IndexController {

    @GetMapping("/resv")
    public String reserv() {
        return "resv";
    }


}
