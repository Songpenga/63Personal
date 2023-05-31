package com.koreait.restaurant.web.controller.reserve_Page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"","/index"})
    public String index() {
        return "index";
    }
}
