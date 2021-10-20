package com.alfatask.currencyChecker.service;

import org.springframework.http.ResponseEntity;

import java.net.URI;

public interface DownloadGifService {
    ResponseEntity<byte[]> getGifByUrl(URI uri);
}
