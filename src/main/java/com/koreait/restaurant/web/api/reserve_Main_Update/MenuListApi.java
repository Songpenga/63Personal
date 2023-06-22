package com.koreait.restaurant.web.api.reserve_Main_Update;

import com.koreait.restaurant.service.reserve_Main_Update.MenuListService;
import com.koreait.restaurant.web.dto.CMRespDto;
import com.koreait.restaurant.web.dto.reserve_Main_Update.MenuListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MenuListApi {

    @Autowired
    private MenuListService menuListService;


    @GetMapping("/admin/main/menus")
    public ResponseEntity<CMRespDto<?>> getMenuList(MenuListDto menuListDto) {
        System.out.println(menuListService.getMenuService(menuListDto));
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "sucessfully", menuListService.getMenuService(menuListDto)));
    }
}
