package com.alfatask.currencyChecker.service.Impl;

import com.alfatask.currencyChecker.client.CurrencyClient;
import com.alfatask.currencyChecker.dto.CurrencyDTO;
import com.alfatask.currencyChecker.service.CurrencyService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Data
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyClient currencyClient;
    private final String api_key;

    public CurrencyServiceImpl(CurrencyClient currencyClient, @Value("${currency.api_key}") String api_key) {
        this.currencyClient = currencyClient;
        this.api_key = api_key;
    }

    @Override
    public ResponseEntity<CurrencyDTO> getCurrency(String date, String baseCurrency) {
        return currencyClient.getCurrency(date, api_key, baseCurrency);
    }

}
