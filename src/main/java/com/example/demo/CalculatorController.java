package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
class CalculatorController {
    List<BigDecimal> numbers = new ArrayList<>();

    @PostMapping("calculator")
    void postNumber(@RequestBody BigDecimal number){
        numbers.add(number);
    }

    @GetMapping("calculator")
    Average calculateAverage(){
        return Average.createAverage(numbers);
    }

    @GetMapping("numbers")
    List<BigDecimal> getNumbers(){
        return numbers;
    }
}
