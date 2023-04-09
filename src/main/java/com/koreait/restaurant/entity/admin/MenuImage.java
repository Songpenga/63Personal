package com.koreait.restaurant.entity.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuImage {
    private int imageId;
    private String menuCode;
    private String saveName;
    private String originName;
}
