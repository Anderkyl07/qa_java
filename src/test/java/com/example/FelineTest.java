
package com.example;

import static org.junit.jupiter.api.Assertions.*;
        import org.junit.jupiter.api.Test;

import java.util.List;

public class FelineTest {

    Feline feline = new Feline();

    
    @Test
    void eatMeatReturnsNotNull() throws Exception {
        List<String> food = feline.eatMeat();
        assertNotNull(food);
    }

    @Test
    void eatMeatReturnsNonEmptyList() throws Exception {
        List<String> food = feline.eatMeat();
        assertFalse(food.isEmpty());
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