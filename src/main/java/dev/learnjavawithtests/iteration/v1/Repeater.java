package dev.learnjavawithtests.iteration.v1;

public final class Repeater {
    private static final int REPEAT_COUNT = 5;

    private Repeater() {
    }

    public static String repeat(String value) {
        StringBuilder repeated = new StringBuilder();
        for (int i = 0; i < REPEAT_COUNT; i++) {
            repeated.append(value);
        }
        return repeated.toString();
    }
}

