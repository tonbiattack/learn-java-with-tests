package dev.learnjavawithtests.springsecurity.v1;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class SecureApiController {
    private final ProfileService profileService;
    private final AdminReportService adminReportService;

    public SecureApiController(ProfileService profileService, AdminReportService adminReportService) {
        this.profileService = profileService;
        this.adminReportService = adminReportService;
    }

    @GetMapping("/profile")
    public ProfileResponse profile(Authentication authentication) {
        return profileService.profileFor(authentication);
    }

    @PostMapping("/admin/reports")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminReportResponse createReport(@Valid @RequestBody AdminReportRequest request) {
        return adminReportService.createReport(request.title());
    }
}
