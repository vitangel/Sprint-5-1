package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFeline {

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String expectedResult = "Кошачьи";
        assertEquals(expectedResult, feline.getFamily(), "Ошибка: ФР не соответствует ОР");
    }
    @Test
    public void testGetKittensNoArgs() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());  // ← Этого теста нет
    }
    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedResult, feline.eatMeat(), "Ошибка: ФР не соответствует ОР");
    }
}
