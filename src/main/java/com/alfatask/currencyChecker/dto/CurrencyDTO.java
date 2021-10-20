package com.alfatask.currencyChecker.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class CurrencyDTO {
    private String disclaimer;
    private String license;
    private long timestamp;
    private String base;
    private Map<String , BigDecimal> rates;
}
