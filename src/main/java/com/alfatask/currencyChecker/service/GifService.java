package com.alfatask.currencyChecker.service;

import com.alfatask.currencyChecker.dto.GifDTO;
import org.springframework.http.ResponseEntity;

public interface GifService {
    ResponseEntity<GifDTO> getGifResponse(String tag);
}
