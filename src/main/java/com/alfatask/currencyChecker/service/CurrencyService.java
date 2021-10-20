package com.alfatask.currencyChecker.service;

import com.alfatask.currencyChecker.dto.CurrencyDTO;
import org.springframework.http.ResponseEntity;

public interface CurrencyService {
    ResponseEntity<CurrencyDTO> getCurrency(String date, String baseCurrency);
}
