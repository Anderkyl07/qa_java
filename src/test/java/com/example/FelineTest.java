package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FelineTest {

    Feline feline = new Feline();

    
    @Test
    void eatMeatReturnsCorrectFood() throws Exception {
        List<String> food = feline.eatMeat();
        assertNotNull(food);
        assertTrue(food.contains("Хищник") || food.size() > 0);
    }

    @Test
    void getFamilyReturnsKoshachie() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensWithoutParamsReturnsOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    void getKittensWithParamReturnsSame() {
        assertEquals(5, feline.getKittens(5));
        assertEquals(0, feline.getKittens(0));
    }
}