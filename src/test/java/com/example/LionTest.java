package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class LionTest {

    private Feline felineMock;

    @BeforeEach
    void setUp() {
        felineMock = mock(Feline.class);
    }

    @Test
    void doesHaveManeReturnsTrueForMale() throws Exception {
        Lion lion = new Lion(felineMock, "Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void doesHaveManeReturnsFalseForFemale() throws Exception {
        Lion lion = new Lion(felineMock, "Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void constructorThrowsExceptionForInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> new Lion(felineMock, "Другой"));
        assertTrue(exception.getMessage().contains("Используйте допустимые значения пола животного"));
    }

    @Test
    void getKittensReturnsExpectedValue() {
        when(felineMock.getKittens()).thenReturn(3);
        Lion lion = null;
        try {
            lion = new Lion(felineMock, "Самец");
        } catch (Exception e) {
            fail("Не ожидалось исключение");
        }
        // Проверка, что метод возвращает значение из Feline
        assertEquals(3, lion.getKittens());
    }

    @Test
    void getKittensCallsFelineGetKittens() {
        when(felineMock.getKittens()).thenReturn(3);
        Lion lion = null;
        try {
            lion = new Lion(felineMock, "Самец");
            lion.getKittens();  // вызываем, чтобы проверить вызов
        } catch (Exception e) {
            fail("Не ожидалось исключение");
        }
        // Проверка, что метод вызван один раз
        verify(felineMock, times(1)).getKittens();
    }

    @Test
    void getFoodReturnsCorrectFoodList() throws Exception {
        List<String> foods = Arrays.asList("Мясо", "Птицы");
        when(felineMock.getFood("Хищник")).thenReturn(foods);

        Lion lion = new Lion(felineMock, "Самка");
        List<String> result = lion.getFood();

        assertEquals(foods, result);
    }

    @Test
    void getFoodCallsFelineGetFoodWithCorrectParameter() throws Exception {
        when(felineMock.getFood("Хищник")).thenReturn(Arrays.asList("Мясо", "Птицы"));

        Lion lion = new Lion(felineMock, "Самка");
        lion.getFood();

        verify(felineMock).getFood("Хищник");
    }

    // 3) Параметризированный тест для проверки поведения в зависимости от пола
    @ParameterizedTest(name = "sex={0}, expectedMane={1}")
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })

    void doesHaveManeParameterized(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(felineMock, sex);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
