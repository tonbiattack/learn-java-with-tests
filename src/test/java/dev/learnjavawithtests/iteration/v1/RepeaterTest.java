package dev.learnjavawithtests.iteration.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RepeaterTest {

    @Test
    void repeatsFiveTimes() {
        assertEquals("aaaaa", Repeater.repeat("a"));
    }
}

