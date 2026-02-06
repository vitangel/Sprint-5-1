package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void getFoodForHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, animal.getFood("Травоядное"));
    }

    @Test
    void getFoodForPredator() throws Exception {
        Animal animal = new Animal();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, animal.getFood("Хищник"));
    }

    @Test
    void getFoodThrowsExceptionForUnknownType() {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () ->
                animal.getFood("Неизвестный")
        );
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }

    @Test
    void getFamily() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Травоядное", "Хищник"})
    void getFoodForValidTypes(String animalType) throws Exception {
        Animal animal = new Animal();
        assertNotNull(animal.getFood(animalType));
    }
}