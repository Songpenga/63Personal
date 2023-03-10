package com.koreait.restaurant.service;

import com.koreait.restaurant.Dto.SelectMenuDto;
import com.koreait.restaurant.entity.SelectMenuEntity;
import com.koreait.restaurant.repository.SelectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SelectService {
    private final SelectRepository searchRepository;

    public List<SelectMenuEntity> getMenu(SelectMenuDto selectMenuDto) {


        return searchRepository.userSelectMenu(selectMenuDto);
    }
}
