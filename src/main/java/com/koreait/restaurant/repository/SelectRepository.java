package com.koreait.restaurant.repository;

import com.koreait.restaurant.Dto.SelectMenuDto;
import com.koreait.restaurant.entity.SelectMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SelectRepository {
    public List<SelectMenu> userSelectBook(SelectMenuDto selectMenuDto);
}
