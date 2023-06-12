package com.koreait.restaurant.repository.admin;

import com.koreait.restaurant.entity.admin.MenuImage;
import com.koreait.restaurant.entity.admin.MenuMst;
import com.koreait.restaurant.web.dto.admin.MenuReqDto;
import com.koreait.restaurant.web.dto.admin.SearchNumberListReqDto;
import com.koreait.restaurant.web.dto.admin.SearchReqDto;
import org.apache.ibatis.annotations.Mapper;

import com.koreait.restaurant.web.dto.reserve_Main_Update.MenuListDto;

import java.util.List;

@Mapper
public interface MenuRepository {
    //admin
    public int getMenuTotalCount(SearchNumberListReqDto searchNumberListReqDto);
    public List<MenuMst> searchMenu(SearchReqDto searchSReqDto);

    public MenuMst findMenuByMenuCode(String menuCode);

    public int saveMenu(MenuReqDto menuReqDto);

    public int updateMenuByMenuCode(MenuReqDto menuReqDto);
    public int maintainUpdateMenuByMenuCode(MenuReqDto menuReqDto);

    public int deleteMenu(String menuCode);

    public int registerMenuImages(List<MenuImage> menuImages);

    public List<MenuImage> findMenuImageAll(String menuCode);
    public MenuImage findMenuImageByImageId(int imageId);
    public MenuImage findMenuImageByMenuCode(String menuCode);

    public int deleteMenuImage(int imageId);


    /*BookCh&main*/
    public List<MenuListDto> getMenuList(MenuListDto menuListDto);

}
