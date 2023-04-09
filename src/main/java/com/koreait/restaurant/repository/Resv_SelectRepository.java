package com.koreait.restaurant.repository;
import com.koreait.restaurant.web.dto.Resv_SelectMenuDto;
import com.koreait.restaurant.entity.Resv_SelectMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Resv_SelectRepository {
    public List<Resv_SelectMenuEntity> userSelectMenu(Resv_SelectMenuDto resvSelectMenuDto);
}
