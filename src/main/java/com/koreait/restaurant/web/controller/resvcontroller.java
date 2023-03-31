package com.koreait.restaurant.web.controller;
//insert

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/insert")
public class resvcontroller {

    @GetMapping("/register")
    public String register(){return  "register";}
}
