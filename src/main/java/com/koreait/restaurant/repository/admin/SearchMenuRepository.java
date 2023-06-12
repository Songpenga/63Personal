
package com.koreait.restaurant.repository.admin;

import com.koreait.restaurant.entity.admin.SearchMenuMst;
import com.koreait.restaurant.web.dto.admin.SearchMenuReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMenuRepository {
    public int getAdminSearchMenuTotalCount(SearchMenuReqDto searchMenuReqDto);
    public List<SearchMenuMst> adminSearchMenu(SearchMenuReqDto searchMenuReqDto);
}