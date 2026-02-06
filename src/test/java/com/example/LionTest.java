package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LionTest {
    private static final List<String> EXPECTED_FOOD = List.of("Животные", "Птицы", "Рыба");

    @Mock
    private Feline feline;

    @Test
    void invalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () ->
                new Lion("Неизвестно", feline)
        );
        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }

    @Test
    void maleLionHasMane() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void femaleLionHasNoMane() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void getKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);
        assertEquals(1, lion.getKittens());
    }

    @Test
    void getFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(EXPECTED_FOOD);
        Lion lion = new Lion("Самец", feline);
        assertEquals(EXPECTED_FOOD, lion.getFood());
    }

    @Test
    void getKittensCallsFelineMethod() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самка", feline);
        assertEquals(3, lion.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }
}