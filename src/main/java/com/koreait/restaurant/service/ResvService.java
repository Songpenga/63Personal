package com.koreait.restaurant.service;

import com.koreait.restaurant.Dto.ResvDto;
import com.koreait.restaurant.repository.ResvRepository;
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
