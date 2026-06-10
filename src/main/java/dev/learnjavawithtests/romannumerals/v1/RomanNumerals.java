package dev.learnjavawithtests.romannumerals.v1;

import java.util.LinkedHashMap;
import java.util.Map;

public final class RomanNumerals {
    private static final LinkedHashMap<Integer, String> NUMERALS = new LinkedHashMap<>();

    static {
        NUMERALS.put(1000, "M");
        NUMERALS.put(900, "CM");
        NUMERALS.put(500, "D");
        NUMERALS.put(400, "CD");
        NUMERALS.put(100, "C");
        NUMERALS.put(90, "XC");
        NUMERALS.put(50, "L");
        NUMERALS.put(40, "XL");
        NUMERALS.put(10, "X");
        NUMERALS.put(9, "IX");
        NUMERALS.put(5, "V");
        NUMERALS.put(4, "IV");
        NUMERALS.put(1, "I");
    }

    public String toRoman(int number) {
        StringBuilder result = new StringBuilder();
        int remaining = number;

        for (Map.Entry<Integer, String> entry : NUMERALS.entrySet()) {
            while (remaining >= entry.getKey()) {
                result.append(entry.getValue());
                remaining -= entry.getKey();
            }
        }
        return result.toString();
    }

    public int fromRoman(String roman) {
        int result = 0;
        String remaining = roman;

        for (Map.Entry<Integer, String> entry : NUMERALS.entrySet()) {
            while (remaining.startsWith(entry.getValue())) {
                result += entry.getKey();
                remaining = remaining.substring(entry.getValue().length());
            }
        }
        return result;
    }
}

