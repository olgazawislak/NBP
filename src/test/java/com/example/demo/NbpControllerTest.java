package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NbpControllerTest {

    @Autowired
    NbpController controller;

    @Test
    void dollarTest() {
        ExchangeRate nameOfCurrency = controller.getNameOfCurrency();
        assertEquals("dolar amerykański", nameOfCurrency.getCurrency());
    }

    @Test
    void averageTest() {
//      given
        NbpController mock = Mockito.mock(NbpController.class);
        Mockito.when(mock.getNameOfCurrency()).thenReturn(new ExchangeRate("0","USD",
                Collections.singletonList(new Rates(new BigDecimal("3.8519"),new BigDecimal("3.9297")))));
//      when
        ExchangeRate nameOfCurrency = mock.getNameOfCurrency();
        assertEquals(new BigDecimal("3.8908"), nameOfCurrency.getAverageOfBidAsk());
    }


}