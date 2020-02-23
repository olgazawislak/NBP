package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Document
public
class ExchangeRate {
    @Id
    private String id;
    private String currency;
    private List<Rates> rates;

    public ExchangeRate(String id, String currency, List<Rates> rates) {
        this.id = id;
        this.currency = currency;
        this.rates = rates;
    }

    public ExchangeRate() {
    }

    String getCurrency() {
        return currency;
    }

    BigDecimal getAverageOfBidAsk(){
        return (rates.get(0).getBid().add(rates.get(0).getAsk())).divide(new BigDecimal(2));
    }
}
