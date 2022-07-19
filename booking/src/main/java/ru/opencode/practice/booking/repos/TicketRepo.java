package ru.opencode.practice.booking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.opencode.practice.booking.models.Booking;
import ru.opencode.practice.booking.models.Ticket;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket, String> {
    public List<Ticket> findTopByOrderByNumberDesc();
}
