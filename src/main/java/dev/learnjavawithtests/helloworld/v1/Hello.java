package dev.learnjavawithtests.helloworld.v1;

public final class Hello {
    private static final String DEFAULT_NAME = "World";

    private Hello() {
    }

    public static String hello(String name, Language language) {
        String normalizedName = (name == null || name.isBlank()) ? DEFAULT_NAME : name;
        return switch (language) {
            case FRENCH -> "Bonjour, " + normalizedName;
            case SPANISH -> "Hola, " + normalizedName;
            case ENGLISH -> "Hello, " + normalizedName;
        };
    }

    public enum Language {
        ENGLISH,
        SPANISH,
        FRENCH
    }
}

