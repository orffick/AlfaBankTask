package com.alfatask.currencyChecker.service.Impl;

import com.alfatask.currencyChecker.dto.CurrencyDTO;
import com.alfatask.currencyChecker.dto.GifDTO;
import com.alfatask.currencyChecker.service.CurrencyService;
import com.alfatask.currencyChecker.service.DownloadGifService;
import com.alfatask.currencyChecker.service.GifChooserByCurrencyService;
import com.alfatask.currencyChecker.service.GifService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

@Service
@Data
public class GifChooserByCurrencyServiceImpl implements GifChooserByCurrencyService {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private GifService gifService;

    @Autowired
    private DownloadGifService downloadGifService;

    @Value("${currency.default}")
    private String currency_default;

    public ResponseEntity<byte[]> getGifByCurrency(String baseCurrency) {

        CurrencyDTO currencyDTO_1 = getCurrency(baseCurrency, 0); // сегодня
        CurrencyDTO currencyDTO_2 = getCurrency(baseCurrency, 1); // вчера

        BigDecimal rate_1 = getRate(currencyDTO_1);
        BigDecimal rate_2 = getRate(currencyDTO_2);

        String tag = rate_1.compareTo(rate_2) > 0 ? "rich" : "broke";

        GifDTO gifDTO = gifService.getGifResponse(tag).getBody();
        String url = String.valueOf(Objects.requireNonNull(gifDTO).getData().get("image_original_url"));

        return downloadGifService.getGifByUrl(URI.create(url));
    }

    private CurrencyDTO getCurrency(String baseCurrency, int days){
        return currencyService.getCurrency(formatDateFromNow(days), baseCurrency).getBody();
    }

    private BigDecimal getRate(CurrencyDTO currencyDTO){
        return (Objects.requireNonNull(currencyDTO)).getRates().get(currency_default);
    }

    private String formatDateFromNow(int days) {
        LocalDateTime dateTime = LocalDateTime.now().minusDays(days);
        return DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(dateTime);
    }
}
