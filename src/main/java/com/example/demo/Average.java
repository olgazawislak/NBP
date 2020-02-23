package com.example.demo;

import java.util.List;

class Average {
    private List<Double> numbers;
    private double average;

    public Average(List<Double> numbers) {
        this.numbers = numbers;
        this.average = numbers.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }
}
