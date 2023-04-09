package com.koreait.restaurant.service;

import com.koreait.restaurant.web.dto.MenuListDto;
import com.koreait.restaurant.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuListService {
    @Autowired
    private final MenuRepository menuRepository;

    public List<MenuListDto> getMenuService(MenuListDto menuListDto) {

        return menuRepository.getMenuList(menuListDto);
    }
}
