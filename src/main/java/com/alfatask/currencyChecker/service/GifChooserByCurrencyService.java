package com.alfatask.currencyChecker.service;

import org.springframework.http.ResponseEntity;

public interface GifChooserByCurrencyService {
    ResponseEntity<byte[]> getGifByCurrency(String baseCurrency);
}
