package com.eptiq.bikebooking.service;

import com.eptiq.bikebooking.model.SalesReport;
import com.eptiq.bikebooking.repository.SalesReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesReportService {

    @Autowired
    private SalesReportRepository salesReportRepository;

    public List<SalesReport> getAllReports() {
        return salesReportRepository.findAll();
    }

    public SalesReport getReportById(Long id) {
        return salesReportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SalesReport not found with id: " + id));
    }

    public SalesReport saveReport(SalesReport salesReport) {
        return salesReportRepository.save(salesReport);
    }

    public void deleteReport(Long id) {
        if (!salesReportRepository.existsById(id)) {
            throw new RuntimeException("SalesReport not found with id: " + id);
        }
        salesReportRepository.deleteById(id);
    }

}
