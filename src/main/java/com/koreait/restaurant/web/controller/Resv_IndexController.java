package com.koreait.restaurant.web.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class Resv_IndexController {

    @GetMapping("/resv")
    public String reserv() {
        return "resv";
    }


}
