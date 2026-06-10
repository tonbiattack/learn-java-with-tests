package dev.learnjavawithtests.springsecurity.v1;

import java.util.List;

public record ProfileResponse(String username, List<String> authorities) {
}
