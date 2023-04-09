package com.koreait.restaurant.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/reservation")
public class Resv_CheckController {

    @GetMapping("/check")
    public String loadcheck() {
        return "/check";
    }

    @GetMapping("/check/input")
    public String loadCheckInput() {
        return "check_input";
    }

    @GetMapping("/modification")
    public String loadModificationPage() {
        return "modification";
    }
}


