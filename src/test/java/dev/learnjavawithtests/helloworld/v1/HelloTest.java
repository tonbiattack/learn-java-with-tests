package dev.learnjavawithtests.helloworld.v1;

import org.junit.jupiter.api.Test;

import static dev.learnjavawithtests.helloworld.v1.Hello.Language.ENGLISH;
import static dev.learnjavawithtests.helloworld.v1.Hello.Language.FRENCH;
import static dev.learnjavawithtests.helloworld.v1.Hello.Language.SPANISH;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloTest {

    @Test
    void saysHelloToAPerson() {
        assertEquals("Hello, Chris", Hello.hello("Chris", ENGLISH));
    }

    @Test
    void fallsBackToWorldForBlankNames() {
        assertEquals("Hello, World", Hello.hello("", ENGLISH));
    }

    @Test
    void greetsInSpanish() {
        assertEquals("Hola, Elodie", Hello.hello("Elodie", SPANISH));
    }

    @Test
    void greetsInFrench() {
        assertEquals("Bonjour, Lauren", Hello.hello("Lauren", FRENCH));
    }
}

