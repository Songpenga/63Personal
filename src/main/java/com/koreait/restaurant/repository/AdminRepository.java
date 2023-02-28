package com.koreait.restaurant.repository;

import com.koreait.restaurant.Dto.AdminDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminRepository {
    public AdminDto adminLogin(AdminDto adminDTO);
}
