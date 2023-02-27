package com.koreait.restaurant.controller;

import com.koreait.restaurant.Dto.AdminDto;
import com.koreait.restaurant.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping()
public class AdminController {

    private AdminService adminService;

    @GetMapping
    public void getlogintest(){
        System.out.println("test");

    }

    @PostMapping("/admin/login")
    public String login(AdminDto adminDto, HttpSession httpSession) throws Exception{
//        adminDto = adminService.getAdminService(adminDto);
        return "resv";
    }

}
