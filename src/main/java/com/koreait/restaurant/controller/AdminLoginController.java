package com.koreait.restaurant.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@Slf4j
@RequestMapping(value = "/admin")
public class AdminLoginController {

    @GetMapping("/index")
    public String adminHome() {
        return "admin/admin_home";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginForm(){
        System.out.println("관리자 로그인페이지 이동");
        return "admin/admin_login";
    }


}
