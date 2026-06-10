package dev.learnjavawithtests.springsecurity.v1;

import jakarta.validation.constraints.NotBlank;

public record AdminReportRequest(@NotBlank String title) {
}
