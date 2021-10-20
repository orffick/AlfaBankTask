package com.alfatask.currencyChecker.service.Impl;

import com.alfatask.currencyChecker.client.GifClient;
import com.alfatask.currencyChecker.dto.GifDTO;
import com.alfatask.currencyChecker.service.GifService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Data
public class GifServiceImpl implements GifService {

    private final GifClient gifClient;
    private final String api_key;

    public GifServiceImpl(GifClient gifClient, @Value("${gif.api_key}") String api_key) {
        this.gifClient = gifClient;
        this.api_key = api_key;
    }

    public ResponseEntity<GifDTO> getGifResponse(String tag) {
        return gifClient.getGif(api_key, tag);
    }
}
