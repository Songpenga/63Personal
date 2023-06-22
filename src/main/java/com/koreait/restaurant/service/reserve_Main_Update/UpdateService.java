package com.koreait.restaurant.service.reserve_Main_Update;

import com.koreait.restaurant.entity.UpdateUserEntity;
import com.koreait.restaurant.web.dto.reserve_Main_Update.UpdateUseReqDto;
import com.koreait.restaurant.repository.reserve_Main_Update.UpdateRepository;
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
