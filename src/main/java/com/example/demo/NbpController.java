package com.example.demo;

import com.example.demo.mongo.ExchangeRateRepository;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class NbpController {

    private ExchangeRateRepository exchangeRateRepository;

    @Autowired
    public NbpController(ExchangeRateRepository exchangeRateRepository) {
        this.exchangeRateRepository = exchangeRateRepository;
    }
    @GetMapping("hello")
    String helloWorld(){
       return "Hello World";
    }

    @GetMapping("exchange-rates")
    JsonNode getActualExchangeRates() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("http://api.nbp.pl/api/exchangerates/tables/{table}/")
                .routeParam("table", "C")
                .header("accept", "application/json")
                .asJson();
        return response.getBody();
    }

    @SneakyThrows
    @GetMapping("currency")
    ExchangeRate getNameOfCurrency() {
        ExchangeRate exchangeRate = Unirest.get("http://api.nbp.pl/api/exchangerates/rates/C/{code}/")
                .routeParam("code", "USD")
                .asObject(ExchangeRate.class)
                .getBody();
        exchangeRateRepository.save(exchangeRate);
        return exchangeRate;
    }

    double calculateAverage(){
        List<ExchangeRate> exchangeRates = exchangeRateRepository.findAll();
        return exchangeRates.stream()
                .mapToDouble(ExchangeRate::getAverageOfBidAsk)
                .average().getAsDouble();
    }
}
