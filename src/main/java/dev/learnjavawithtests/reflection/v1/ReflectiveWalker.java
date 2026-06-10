package dev.learnjavawithtests.reflection.v1;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Consumer;

public final class ReflectiveWalker {
    public void walk(Object input, Consumer<String> visitor) {
        if (input == null) {
            return;
        }

        if (input instanceof String text) {
            visitor.accept(text);
            return;
        }

        if (input instanceof Iterable<?> iterable) {
            for (Object element : iterable) {
                walk(element, visitor);
            }
            return;
        }

        if (input instanceof Map<?, ?> map) {
            for (Object value : map.values()) {
                walk(value, visitor);
            }
            return;
        }

        Class<?> type = input.getClass();
        if (type.isArray()) {
            int length = Array.getLength(input);
            for (int index = 0; index < length; index++) {
                walk(Array.get(input, index), visitor);
            }
            return;
        }

        for (Field field : type.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                walk(field.get(input), visitor);
            } catch (IllegalAccessException exception) {
                throw new IllegalStateException(exception);
            }
        }
    }
}

