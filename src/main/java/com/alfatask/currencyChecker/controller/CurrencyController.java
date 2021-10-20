package com.alfatask.currencyChecker.controller;

import com.alfatask.currencyChecker.service.GifChooserByCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private GifChooserByCurrencyService gifChooser;

    @GetMapping("/gif/{base}")
    public ResponseEntity<byte[]> getGif(@PathVariable("base") String baseCurrency){
        return gifChooser.getGifByCurrency(baseCurrency);

    }

    @GetMapping("/*")
    public ResponseEntity<byte[]> getGif(){
        return gifChooser.getGifByCurrency("USD");
    }
}
