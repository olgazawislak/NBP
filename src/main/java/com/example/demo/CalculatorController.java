package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
class CalculatorController {
    List<Double> numbers = new ArrayList<>();

    @PostMapping("calculator")
    void postNumber(@RequestBody double number){
        numbers.add(number);
    }

    @GetMapping("calculator")
    Average calculateAverage(){
        return new Average(numbers);
    }

    @GetMapping("numbers")
    List<Double> getNumbers(){
        return numbers;
    }
}
