package ru.opencode.practice.booking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.opencode.practice.booking.models.Booking;
import ru.opencode.practice.booking.models.Ticket;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, String> {
    @Query(value = "select * from bookings.tickets limit 10", nativeQuery = true)
    List<Ticket> getTickets();
}
