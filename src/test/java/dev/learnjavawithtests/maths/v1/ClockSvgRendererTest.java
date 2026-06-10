package dev.learnjavawithtests.maths.v1;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ClockSvgRendererTest {

    @Test
    void rendersAnSvgClock() {
        String svg = new ClockSvgRenderer().render(LocalTime.of(12, 0, 0));

        assertTrue(svg.startsWith("<svg"));
        assertTrue(svg.contains("id=\"hour\""));
        assertTrue(svg.contains("id=\"minute\""));
        assertTrue(svg.contains("id=\"second\""));
        assertTrue(svg.contains("x2=\"100\" y2=\"60\""));
    }
}

