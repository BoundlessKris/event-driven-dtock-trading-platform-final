package com.trading.stockpriceservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock-price")

public class StockController {

    @GetMapping("/hello")
    public String hello() {
        return "stock price service is working";
    }
}
