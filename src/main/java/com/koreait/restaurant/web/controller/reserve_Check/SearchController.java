package com.koreait.restaurant.web.controller.reserve_Check;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {

    @GetMapping("")
    public String loadSearch() {
        return "search";
    }

}