package com.eptiq.bikebooking.service;

import com.eptiq.bikebooking.model.GSTReport;
import com.eptiq.bikebooking.repository.GSTReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GSTReportService {

    @Autowired
    private GSTReportRepository gstReportRepository;

    public List<GSTReport> getAllReports() {
        return gstReportRepository.findAll();
    }

    public GSTReport getReportById(Long id) {
        return gstReportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("GSTReport not found with id: " + id));
    }

    public GSTReport saveReport(GSTReport gstReport) {
        return gstReportRepository.save(gstReport);
    }

    public void deleteReport(Long id) {
        if (!gstReportRepository.existsById(id)) {
            throw new RuntimeException("GSTReport not found with id: " + id);
        }
        gstReportRepository.deleteById(id);
    }
}
