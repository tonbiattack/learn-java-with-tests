package dev.learnjavawithtests.arrays.v1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumCalculatorTest {

    @Test
    void sumsNumbersInAnArray() {
        assertEquals(15, SumCalculator.sum(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void sumsMultipleArrays() {
        List<Integer> totals = SumCalculator.sumAll(List.of(
                new int[]{1, 2},
                new int[]{0, 9}
        ));

        assertEquals(List.of(3, 9), totals);
    }
}

