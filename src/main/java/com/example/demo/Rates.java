package com.example.demo;

import lombok.Getter;

import java.math.BigDecimal;
@Getter
class Rates {
    private BigDecimal bid;
    private BigDecimal ask;

    public Rates(BigDecimal bid, BigDecimal ask) {
        this.bid = bid;
        this.ask = ask;
    }

    public Rates() {
    }
}
