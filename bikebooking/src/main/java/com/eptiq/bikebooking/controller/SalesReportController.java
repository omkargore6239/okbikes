package com.eptiq.bikebooking.controller;

import com.eptiq.bikebooking.model.SalesReport;
import com.eptiq.bikebooking.service.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/salesReports")
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @GetMapping
    public List<SalesReport> getAllReports() {
        return salesReportService.getAllReports();
    }

    @GetMapping("/{id}")
    public SalesReport getReportById(@PathVariable Long id) {
        return salesReportService.getReportById(id);
    }

    @PostMapping
    public SalesReport createReport(@RequestBody SalesReport salesReport) {
        return salesReportService.saveReport(salesReport);
    }

    @DeleteMapping("/{id}")
    public String deleteReport(@PathVariable Long id) {
        salesReportService.deleteReport(id);
        return "SalesReport with id " + id + " has been deleted.";
    }

}
