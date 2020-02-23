package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class AverageTest {

    @Test
    void averageTest(){
        assertEquals(new Average(Collections.emptyList(), null), Average.createAverage(Collections.emptyList()));
    }

}