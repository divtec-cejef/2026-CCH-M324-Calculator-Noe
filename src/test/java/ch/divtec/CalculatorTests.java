package ch.divtec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTests {
    private final Calculator calc = new Calculator();

    @Test
    void addNormal() {
        assertEquals(4, calc.add(2, 2));
    }

    @Test
    void addNegative() {
        assertEquals(-1, calc.add(2, -3));
    }

    @Test
    void subtractNormal() {
        assertEquals(1, calc.subtract(3, 2));
    }

    @Test
    void subtractNegative() {
        assertEquals(-4, calc.subtract(3, 7));
    }

    @Test
    void subtractBothNegative() {
        assertEquals(-3, calc.subtract(-8, -5));
    }

    @Test
    void multiplyNormal() {
        assertEquals(15, calc.multiply(3, 5));
    }

    @Test
    void multiplyNegative() {
        assertEquals(-12, calc.multiply(-3, 4));
    }

    @Test
    void multiplyFirstZero() {
        assertEquals(0, calc.multiply(0, -5678903), 0.000000000000000000000000001);
    }

    @Test
    void divideNormal() {
        assertEquals(0.6, calc.divide(3, 5));
    }

    @Test
    void divideNegative() {
        assertEquals(-0.8, calc.divide(-4, 5));
    }

    @Test
    void factorialNormal() {
        assertEquals(6, calc.factorial(3));
    }

    @Test
    void factorialOfZero() {
        assertEquals(1, calc.factorial(0));
    }

    @Test
    void factorialDecimal() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.factorial(3.2);
        });

        String expectedMessage = "Number must be an integer";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void factorialNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.factorial(-5);
        });

        String expectedMessage = "Number must be positive";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
