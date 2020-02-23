package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@EqualsAndHashCode
@AllArgsConstructor
class Average {
    private List<BigDecimal> numbers;
    private BigDecimal average;

    public static Average createAverage(List<BigDecimal> numbers) {
        if (numbers.size() == 0) {
            return new Average(numbers, null);
        }
        return new Average(numbers, numbers.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .divide(new BigDecimal(numbers.size()), RoundingMode.DOWN));
    }
}
