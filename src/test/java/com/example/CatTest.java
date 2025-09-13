package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CatTest {

    private Feline felineMock;
    private Cat cat;

    @BeforeEach
    void setUp() {
        felineMock = mock(Feline.class);
        cat = new Cat(felineMock);
    }

    @Test
    void getSoundReturnsMiau() {
        assertEquals("Мяу", cat.getSound());
    }


    @Test
    void getFoodReturnsFoodFromPredator() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        List<String> result = cat.getFood();

        assertEquals(expectedFood, result);
        verify(felineMock, times(1)).eatMeat();
    }
}

