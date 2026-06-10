package dev.learnjavawithtests.shapes.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShapeTest {

    @Test
    void calculatesRectangleArea() {
        assertEquals(12.0, new Rectangle(3.0, 4.0).area());
    }

    @Test
    void calculatesCircleArea() {
        assertEquals(Math.PI * 25, new Circle(5.0).area());
    }
}

