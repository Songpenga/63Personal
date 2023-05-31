package com.koreait.restaurant.service.reserve_Page;

import com.koreait.restaurant.web.dto.reserve_Page.Resv_SelectMenuDto;
import com.koreait.restaurant.entity.Resv_SelectMenuEntity;
import com.koreait.restaurant.repository.reserve_Page.Resv_SelectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class Resv_SelectService {
    private final Resv_SelectRepository searchRepository;

    public List<Resv_SelectMenuEntity> getMenu(Resv_SelectMenuDto resvSelectMenuDto) {


        return searchRepository.userSelectMenu(resvSelectMenuDto);
    }
}
