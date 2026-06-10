package dev.learnjavawithtests.springhttp.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingServiceTest {

    private final GreetingService greetingService = new GreetingService();

    @Test
    void greetsByName() {
        assertEquals(new Greeting("Hello, Chris"), greetingService.greet("Chris"));
    }

    @Test
    void fallsBackToWorld() {
        assertEquals(new Greeting("Hello, World"), greetingService.greet(""));
    }
}

