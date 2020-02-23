package com.example.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

class Average {
    private List<BigDecimal> numbers;
    private BigDecimal average;

    public Average(List<BigDecimal> numbers) {
        this.numbers = numbers;
        this.average = numbers.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(numbers.size()), RoundingMode.DOWN);
    }
}
