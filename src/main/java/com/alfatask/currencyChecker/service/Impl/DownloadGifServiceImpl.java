package com.alfatask.currencyChecker.service.Impl;

import com.alfatask.currencyChecker.client.DownloadGifClient;
import com.alfatask.currencyChecker.service.DownloadGifService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@Data
public class DownloadGifServiceImpl implements DownloadGifService {
    private final DownloadGifClient downloadGifClient;

    @Override
    public ResponseEntity<byte[]> getGifByUrl(URI uri) {
        return downloadGifClient.getGifByUrl(uri);
    }

}