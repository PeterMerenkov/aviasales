package ru.opencode.practice.booking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.opencode.practice.booking.models.Ticket;

import java.util.List;

public interface TicketRepo extends JpaRepository<Ticket, String> {

    Ticket findByNumber(String number);

    List<Ticket> findTopByOrderByNumberDesc();

    @Query("select max(number) from Ticket")
    String getMaxTicketNum();
}
