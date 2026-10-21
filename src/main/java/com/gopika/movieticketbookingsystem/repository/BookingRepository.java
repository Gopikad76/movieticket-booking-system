
package com.gopika.movieticketbookingsystem.repository;

import com.gopika.movieticketbookingsystem.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findByShow_IdAndStatus(Integer showId, String status);
}
