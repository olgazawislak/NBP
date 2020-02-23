package com.example.demo;

import com.example.demo.mongo.ExchangeRateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataMongoTest
class CalculateAverageTest {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Test
    void averageTest() {
        exchangeRateRepository.save(new ExchangeRate("0", "euro", singletonList(new Rates(new BigDecimal(4), new BigDecimal("4.2")))));
        NbpController nbpController = new NbpController(exchangeRateRepository);
        assertEquals(new BigDecimal("4.1"), nbpController.calculateAverage());
    }

    @Test
    void averageSecondTest() {
        exchangeRateRepository.save(new ExchangeRate("0", "euro", singletonList(new Rates(new BigDecimal(4), new BigDecimal("4.2")))));
        exchangeRateRepository.save(new ExchangeRate("1", "euro", singletonList(new Rates(new BigDecimal(2),new BigDecimal("2.6") ))));
        assertEquals(2, exchangeRateRepository.findAll().size(), "Check if the are two elements in database");

        NbpController nbpController = new NbpController(exchangeRateRepository);
        assertEquals(new BigDecimal("3.2"), nbpController.calculateAverage());
    }
}
