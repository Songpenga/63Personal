package com.koreait.restaurant.web.api.reserve_Page;

import com.koreait.restaurant.web.dto.reserve_Page.Resv_SelectMenuDto;
import com.koreait.restaurant.service.reserve_Page.Resv_SelectService;
import com.koreait.restaurant.web.dto.CMRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SelectApi {

    private final Resv_SelectService resvSelectService;

    @GetMapping("/search")
    public ResponseEntity<CMRespDto<?>> search(Resv_SelectMenuDto resvSelectMenuDto) {
        return ResponseEntity.ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(),
                        "Successfully",
                        resvSelectService.getMenu(resvSelectMenuDto)));
    }

}
