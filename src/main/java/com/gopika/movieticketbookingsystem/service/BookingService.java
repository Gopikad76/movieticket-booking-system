
package com.gopika.movieticketbookingsystem.service;

import com.gopika.movieticketbookingsystem.model.Booking;
import com.gopika.movieticketbookingsystem.model.Show;
import com.gopika.movieticketbookingsystem.repository.BookingRepository;
import com.gopika.movieticketbookingsystem.repository.ShowRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ShowRepository showRepository;

    public BookingService(BookingRepository bookingRepository,
                          ShowRepository showRepository) {
        this.bookingRepository = bookingRepository;
        this.showRepository = showRepository;
    }

    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(int id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @Transactional
    public Booking addBooking(Booking booking) {

        if (booking.getShow() == null || booking.getShow().getId() == null) {
            throw new RuntimeException("Show ID is required");
        }

        Show show = showRepository.findById(booking.getShow().getId())
                .orElseThrow(() -> new RuntimeException("Show not found"));

        if (booking.getNumberOfTickets() == null
                || booking.getNumberOfTickets() <= 0) {
            throw new RuntimeException("Number of tickets must be greater than zero");
        }

        if (booking.getSeats() == null || booking.getSeats().isBlank()) {
            throw new RuntimeException("Please select seats");
        }

        String[] selectedSeats = booking.getSeats().split(",");

        Set<String> requestedSeats = new HashSet<>();

        for (String seat : selectedSeats) {
            String seatName = seat.trim().toUpperCase();

            if (seatName.isEmpty()) {
                throw new RuntimeException("Invalid seat selection");
            }

            if (!requestedSeats.add(seatName)) {
                throw new RuntimeException(
                        "Duplicate seat in request: " + seatName);
            }
        }

        if (requestedSeats.size() != booking.getNumberOfTickets()) {
            throw new RuntimeException(
                    "Number of tickets must match the number of selected seats");
        }

        List<Booking> existingBookings =
                bookingRepository.findByShow_IdAndStatus(
                        show.getId(), "CONFIRMED");


        for (Booking existingBooking : existingBookings) {

            if (existingBooking.getSeats() == null) {
                continue;
            }

            Set<String> alreadyBookedSeats = new HashSet<>();

            for (String seat : existingBooking.getSeats().split(",")) {
                alreadyBookedSeats.add(seat.trim().toUpperCase());
            }

            for (String seat : requestedSeats) {
                if (alreadyBookedSeats.contains(seat)) {
                    throw new RuntimeException(
                            "Seat " + seat + " is already booked for this show");
                }
            }
        }

        booking.setShow(show);
        booking.setSeats(String.join(",", requestedSeats));
        booking.setTotalPrice(
                show.getPrice() * booking.getNumberOfTickets());
        booking.setStatus("CONFIRMED");

        return bookingRepository.save(booking);
    }

    public String deleteBooking(int id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        bookingRepository.delete(booking);

        return "Booking deleted successfully";
    }
}
