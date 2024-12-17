package com.eptiq.bikebooking.controller;

import com.eptiq.bikebooking.model.Booking;
import com.eptiq.bikebooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Optional<Booking> booking = bookingService.getBookingById(id);
        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.saveBooking(booking));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking bookingDetails) {
        Optional<Booking> existingBooking = bookingService.getBookingById(id);

        if (existingBooking.isPresent()) {
            Booking booking = existingBooking.get();
            booking.setBookingId(bookingDetails.getBookingId());
            booking.setVehicleNumber(bookingDetails.getVehicleNumber());
            booking.setCustomerName(bookingDetails.getCustomerName());
            booking.setContactNumber(bookingDetails.getContactNumber());
            booking.setAddressType(bookingDetails.getAddressType());
            return ResponseEntity.ok(bookingService.saveBooking(booking));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
