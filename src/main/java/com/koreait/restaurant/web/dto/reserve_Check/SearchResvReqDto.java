package com.koreait.restaurant.web.dto.reserve_Check;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SearchResvReqDto {

    private int reserveId;

    private String reserveName;

    private String number;


}
