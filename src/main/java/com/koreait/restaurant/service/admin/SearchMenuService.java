package com.koreait.restaurant.service.admin;

import com.koreait.restaurant.entity.admin.SearchMenuMst;
import com.koreait.restaurant.repository.admin.SearchMenuRepository;
import com.koreait.restaurant.web.dto.admin.SearchMenuReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchMenuService {

    private final SearchMenuRepository searchMenuRepository;

    public int getSearchMenuTotalCount(SearchMenuReqDto searchMenuReqDto) {
        return searchMenuRepository.getAdminSearchMenuTotalCount(searchMenuReqDto);
    }

    public List<SearchMenuMst> getSearchMenus(SearchMenuReqDto searchMenuReqDto) {
        searchMenuReqDto.setIndex();
        return searchMenuRepository.adminSearchMenu(searchMenuReqDto);
    }


}