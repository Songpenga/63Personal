package com.koreait.restaurant.web.controller.reserve_Main_Update;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/update")
public class updateController {
    @GetMapping("")
    public String updateReserveUser(){
        return "main_Update_Page/modification";
    }


}
