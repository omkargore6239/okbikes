package com.eptiq.bikebooking.repository;

import com.eptiq.bikebooking.model.BookingReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingReportRepository extends JpaRepository<BookingReport, Long> {
}
