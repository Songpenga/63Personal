package com.koreait.restaurant.web.api.reserve_Main_Update;

import com.koreait.restaurant.service.reserve_Main_Update.UpdateService;
import com.koreait.restaurant.web.dto.CMRespDto;
import com.koreait.restaurant.web.dto.reserve_Main_Update.UpdateUseReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UpdateApi {
    @Autowired
    private UpdateService updateService;

    @PutMapping("/user/{reserveId}")
    public ResponseEntity<CMRespDto<?>> modifyUser(@PathVariable String reserveId, @RequestBody UpdateUseReqDto updateUseReqDto) {
        updateService.modifyReserve(updateUseReqDto);
        System.out.println(updateUseReqDto);
        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "successfully", true));
    }

    @GetMapping("/searchuser")
    public ResponseEntity<CMRespDto<?>> getUser(UpdateUseReqDto updateUseReqDto) {
        System.out.println(updateService.searchReserve(updateUseReqDto));
//        updateService.searchReserve(updateUseReqDto);

        return ResponseEntity
                .ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(), "Successfully", updateService.searchReserve(updateUseReqDto)));

    }

}
