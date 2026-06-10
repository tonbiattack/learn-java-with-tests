package dev.learnjavawithtests.maps.v1;

import java.util.HashMap;
import java.util.Map;

public final class Dictionary {
    private final Map<String, String> entries = new HashMap<>();

    public String search(String word) {
        String definition = entries.get(word);
        if (definition == null) {
            throw new WordNotFoundException(word);
        }
        return definition;
    }

    public void add(String word, String definition) {
        if (entries.containsKey(word)) {
            throw new WordAlreadyExistsException(word);
        }
        entries.put(word, definition);
    }

    public void update(String word, String definition) {
        if (!entries.containsKey(word)) {
            throw new WordNotFoundException(word);
        }
        entries.put(word, definition);
    }

    public void delete(String word) {
        entries.remove(word);
    }
}

