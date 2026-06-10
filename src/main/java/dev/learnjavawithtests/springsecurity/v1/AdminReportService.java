package dev.learnjavawithtests.springsecurity.v1;

import org.springframework.stereotype.Service;

@Service
public class AdminReportService {
    public AdminReportResponse createReport(String title) {
        return new AdminReportResponse("created report: " + title);
    }
}
