package dev.learnjavawithtests.springhttp.v1;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public Greeting greet(String name) {
        String resolvedName = (name == null || name.isBlank()) ? "World" : name;
        return new Greeting("Hello, " + resolvedName);
    }
}

