package com.koreait.restaurant.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/home")
    public String adminHome() {
        return "admin/admin_home";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginForm(){
        System.out.println("관리자 로그인페이지 이동");
        return "admin/admin_login";
    }

    @PostMapping("/login/error")
    public String loginError() {
        return "/account/login_error";
    }

    @GetMapping("/register")
    public String register() {
        return "/account/register";
    }
}