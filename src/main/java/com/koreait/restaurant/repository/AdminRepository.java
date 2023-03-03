package com.koreait.restaurant.repository;

import com.koreait.restaurant.entity.AdminEntity;
import com.koreait.restaurant.service.AdminUserDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AdminRepository {

    Optional<AdminUserDetails> findByAdminId(String adminId);

    public AdminEntity getAdmin(String adminId);
}
