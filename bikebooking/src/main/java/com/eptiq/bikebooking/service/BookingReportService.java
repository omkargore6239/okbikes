package com.eptiq.bikebooking.service;

import com.eptiq.bikebooking.model.BookingReport;
import com.eptiq.bikebooking.repository.BookingReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingReportService {

    @Autowired
    private BookingReportRepository bookingReportRepository;

    public List<BookingReport> getAllReports() {
        return bookingReportRepository.findAll();
    }

    public BookingReport getReportById(Long id) {
        return bookingReportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BookingReport not found with id: " + id));
    }

    public BookingReport saveReport(BookingReport bookingReport) {
        return bookingReportRepository.save(bookingReport);
    }

    public void deleteReport(Long id) {
        if (!bookingReportRepository.existsById(id)) {
            throw new RuntimeException("BookingReport not found with id: " + id);
        }
        bookingReportRepository.deleteById(id);
    }
}
