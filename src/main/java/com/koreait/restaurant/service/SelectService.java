package com.koreait.restaurant.service;

import com.koreait.restaurant.Dto.SelectMenuDto;
import com.koreait.restaurant.entity.SelectMenu;
import com.koreait.restaurant.repository.SelectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SelectService {

    private final SelectRepository searchRepository;

    public List<SelectMenu> getMenu(SelectMenuDto selectMenuDto) {

        return SelectRepository.userSelectBook(selectMenuDto);
    }
}
