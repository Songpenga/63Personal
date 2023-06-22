package com.koreait.restaurant.service.reserve_Page;

import com.koreait.restaurant.web.dto.reserve_Page.ResvDto;
import com.koreait.restaurant.repository.reserve_Page.ResvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResvService {

    @Autowired
    private ResvRepository resvRepository;

    public void registerBook(ResvDto resvDto) {
        resvRepository.saveResv(resvDto);
    }
}
