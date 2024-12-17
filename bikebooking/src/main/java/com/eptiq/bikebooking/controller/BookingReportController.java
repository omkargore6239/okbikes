package com.eptiq.bikebooking.controller;

import com.eptiq.bikebooking.model.BookingReport;
import com.eptiq.bikebooking.service.BookingReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/bookingReports")
public class BookingReportController {

    @Autowired
    private BookingReportService bookingReportService;

    @GetMapping
    public List<BookingReport> getAllReports() {
        return bookingReportService.getAllReports();
    }

    @GetMapping("/{id}")
    public BookingReport getReportById(@PathVariable Long id) {
        return bookingReportService.getReportById(id);
    }

    @PostMapping
    public BookingReport createReport(@RequestBody BookingReport bookingReport) {
        return bookingReportService.saveReport(bookingReport);
    }

    @DeleteMapping("/{id}")
    public String deleteReport(@PathVariable Long id) {
        bookingReportService.deleteReport(id);
        return "BookingReport with id " + id + " has been deleted.";
    }

}
