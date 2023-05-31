package com.koreait.restaurant.repository.reserve_Main_Update;

import com.koreait.restaurant.entity.UpdateUserEntity;
import com.koreait.restaurant.web.dto.reserve_Main_Update.UpdateUseReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UpdateRepository {
    public int updateUser(UpdateUseReqDto updateUseReqDto);

    public List<UpdateUserEntity> selectUser(UpdateUseReqDto updateUseReqDto);

}
