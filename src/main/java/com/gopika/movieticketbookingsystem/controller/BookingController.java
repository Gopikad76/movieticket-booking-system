
package com.gopika.movieticketbookingsystem.controller;

import com.gopika.movieticketbookingsystem.model.Booking;
import com.gopika.movieticketbookingsystem.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> getBookings() {
        return bookingService.getBookings();
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable int id) {
        return bookingService.getBookingById(id);
    }


    @PostMapping
    public Object addBooking(@RequestBody Booking booking) {
        try {
            return bookingService.addBooking(booking);
        } catch (RuntimeException e) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("message", e.getMessage()));
        }
    }


    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable int id) {
        return bookingService.deleteBooking(id);
    }
}
