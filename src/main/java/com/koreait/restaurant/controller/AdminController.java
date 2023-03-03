package com.koreait.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class AdminController {

    @PostMapping("/admin/access")
    public String admin(){
        return "/admin/login_home";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "/admin/admin_login_error";
    }
}