package com.koreait.restaurant.service;

import com.koreait.restaurant.entity.AdminEntity;
import com.koreait.restaurant.repository.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*DB에서 정보 가져옴*/
@Service
@Component
@Slf4j
public class AdminLoginService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;


    @Override
    public UserDetails loadUserByUsername(String adminID) throws UsernameNotFoundException {
        AdminEntity admin = adminRepository.getAdmin(adminID);

        if(admin==null) {
            throw new UsernameNotFoundException("회원정보를 확인 할 수 없음");
        }
        return new AdminUserDetails();
    }
}
