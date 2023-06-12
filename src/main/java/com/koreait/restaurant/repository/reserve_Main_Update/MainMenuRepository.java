package com.koreait.restaurant.repository.reserve_Main_Update;

import com.koreait.restaurant.web.dto.reserve_Main_Update.MenuListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMenuRepository {

    public List<MenuListDto> getMenuList(MenuListDto menuListDto);
}
