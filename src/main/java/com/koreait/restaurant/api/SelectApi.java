package com.koreait.restaurant.api;

import com.koreait.restaurant.Dto.CMRespDto;
import com.koreait.restaurant.Dto.SelectMenuDto;
import com.koreait.restaurant.entity.SelectMenuEntity;
import com.koreait.restaurant.service.SelectService;
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

    private final SelectService selectService;

    @GetMapping("/search")
    public ResponseEntity<CMRespDto<?>> search(SelectMenuDto selectMenuDto) {
//        System.out.println(selectService.getMenu(selectMenuEntity));
        return ResponseEntity.ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(),
                        "Successfully",
                        selectService.getMenu(selectMenuDto)));
    }

}
