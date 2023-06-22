package com.koreait.restaurant.web.dto.admin;

import lombok.Data;

import java.util.List;

@Data
public class DeleteMenusReqDto {
    private List<Integer> userIds;
}
