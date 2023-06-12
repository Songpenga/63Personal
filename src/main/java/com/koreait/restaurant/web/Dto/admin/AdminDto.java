package com.koreait.restaurant.web.dto.admin;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminDto {
    private String adminId;
    private String adminPw;
}
