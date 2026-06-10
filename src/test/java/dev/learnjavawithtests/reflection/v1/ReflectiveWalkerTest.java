package dev.learnjavawithtests.reflection.v1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReflectiveWalkerTest {

    @Test
    void findsStringsInFields() {
        ReflectiveWalker walker = new ReflectiveWalker();
        List<String> got = new ArrayList<>();

        walker.walk(new Person("Chris", new Profile("developer")), got::add);

        assertEquals(List.of("Chris", "developer"), got);
    }

    @Test
    void walksArraysListsAndMaps() {
        ReflectiveWalker walker = new ReflectiveWalker();
        List<String> got = new ArrayList<>();

        walker.walk(new Object[]{
                List.of("A", "B"),
                Map.of("ignored", "C")
        }, got::add);

        assertEquals(List.of("A", "B", "C"), got);
    }

    private record Person(String name, Profile profile) {
    }

    private record Profile(String role) {
    }
}

