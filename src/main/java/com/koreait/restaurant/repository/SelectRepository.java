package com.koreait.restaurant.repository;
import com.koreait.restaurant.Dto.SelectMenuDto;
import com.koreait.restaurant.entity.SelectMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SelectRepository {
    public List<SelectMenuEntity> userSelectMenu(SelectMenuDto selectMenuDto);
}
