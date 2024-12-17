package com.eptiq.bikebooking.controller;

import com.eptiq.bikebooking.model.GSTReport;
import com.eptiq.bikebooking.service.GSTReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/gstReports")
public class GSTReportController {

    @Autowired
    private GSTReportService gstReportService;

    @GetMapping
    public List<GSTReport> getAllReports() {
        return gstReportService.getAllReports();
    }

    @GetMapping("/{id}")
    public GSTReport getReportById(@PathVariable Long id) {
        return gstReportService.getReportById(id);
    }

    @PostMapping
    public GSTReport createReport(@RequestBody GSTReport gstReport) {
        return gstReportService.saveReport(gstReport);
    }

    @DeleteMapping("/{id}")
    public String deleteReport(@PathVariable Long id) {
        gstReportService.deleteReport(id);
        return "GSTReport with id " + id + " has been deleted.";
    }
}
