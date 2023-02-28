package com.koreait.restaurant.controller;

import com.koreait.restaurant.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/home")
    public String adminHome() {
        return "admin/admin_home";
    }

//    @PostMapping("/admin/login")

}
