package com.koreait.restaurant.web.api.admin;

import com.koreait.restaurant.aop.annotation.ParamsAspect;
import com.koreait.restaurant.service.admin.SearchReservationService;
import com.koreait.restaurant.web.dto.CMRespDto;
import com.koreait.restaurant.web.dto.admin.SearchReservationReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class SearchReservationApi {

    private final SearchReservationService searchReservationService;

    @GetMapping("/search/reservation")
    public ResponseEntity<CMRespDto<?>> search(SearchReservationReqDto searchReservationReqDto) {

        return ResponseEntity.ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(),
                        "Successfully",
                        searchReservationService.getSearchReservations(searchReservationReqDto)));

    }



    @ParamsAspect
    @GetMapping("/search/reservation/totalcount")
    public ResponseEntity<CMRespDto<Integer>> getSearchReservationTotalCount(SearchReservationReqDto searchReservationReqDto) {
        return ResponseEntity.ok()
                .body(new CMRespDto<>(HttpStatus.OK.value(),
                        "Successfully",
                        searchReservationService.getSearchTotalCount(searchReservationReqDto)));
    }

}
