package com.koreait.restaurant.service;

import com.koreait.restaurant.Dto.AdminDto;
import com.koreait.restaurant.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public AdminDto getAdminService(AdminDto adminDto) throws Exception {
        return adminRepository.getAdmin(adminDto);
    }
}
