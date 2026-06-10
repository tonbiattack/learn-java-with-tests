package dev.learnjavawithtests.integers.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdderTest {

    @Test
    void addsTwoIntegers() {
        assertEquals(4, Adder.add(2, 2));
    }
}

