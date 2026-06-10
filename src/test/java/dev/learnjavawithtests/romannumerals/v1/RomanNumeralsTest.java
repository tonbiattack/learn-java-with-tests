package dev.learnjavawithtests.romannumerals.v1;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumeralsTest {
    private final RomanNumerals romanNumerals = new RomanNumerals();

    @Test
    void convertsKnownExamplesToRoman() {
        assertEquals("I", romanNumerals.toRoman(1));
        assertEquals("IV", romanNumerals.toRoman(4));
        assertEquals("IX", romanNumerals.toRoman(9));
        assertEquals("MCMXCIX", romanNumerals.toRoman(1999));
    }

    @Property
    void roundTripsAnySupportedNumber(@ForAll @IntRange(min = 1, max = 3999) int number) {
        assertEquals(number, romanNumerals.fromRoman(romanNumerals.toRoman(number)));
    }
}
