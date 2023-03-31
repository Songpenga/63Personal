package com.koreait.restaurant.service;

import com.koreait.restaurant.entity.UpdateUserEntity;
import com.koreait.restaurant.web.dto.UpdateUseReqDto;
import com.koreait.restaurant.repository.UpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateService {


    @Autowired
    private UpdateRepository updateRepository;

    public void modifyReserve(UpdateUseReqDto updateUseReqDto) {
        updateRepository.updateUser(updateUseReqDto);
    }

    public List<UpdateUserEntity> searchReserve(UpdateUseReqDto updateUseReqDto) {

        return updateRepository.selectUser(updateUseReqDto);
    }

}
