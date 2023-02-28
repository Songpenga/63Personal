package com.koreait.restaurant.service;

import com.koreait.restaurant.Dto.AdminDto;
import com.koreait.restaurant.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
@RequiredArgsConstructor
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public AdminDto getAdminService(AdminDto adminDto) throws Exception {
        return adminRepository.adminLogin(adminDto);
    }
}
