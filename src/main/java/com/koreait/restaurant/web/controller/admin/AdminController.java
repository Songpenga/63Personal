package com.koreait.restaurant.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/login")
    public String login() {
        return "/admin/admin_login";
    }

    @GetMapping("/main")
    public String AdminMain() {
        return "/admin/admin_main_page";
    }

    @GetMapping("/reservation/management")
    public String reservationManagement() {
        return "/admin/reservation_management";
    }

    @GetMapping("/menu/management")
    public String menuManagement() {
        return "/admin/menu_management";

    }

    @GetMapping("/register")
    public String register() {
        return "/admin/menu_registration";
    }
}