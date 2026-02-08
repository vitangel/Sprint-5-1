package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFelineParameterized {

    Feline feline = new Feline();

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "10, 10"
    })
    public void testGetKittens(int expectedResult, int numberOfKittens) {
        assertEquals(expectedResult, feline.getKittens(numberOfKittens),
                "Ошибка: кол-во котят не совпадает с ожиданием");
    }
}