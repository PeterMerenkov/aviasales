package ru.opencode.practice.booking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.opencode.practice.booking.models.Flight;
import ru.opencode.practice.booking.models.Ticket;
import ru.opencode.practice.booking.models.TicketFlight;
import ru.opencode.practice.booking.models.helpers.TicketFlightId;

import java.util.List;

public interface TicketFlightRepo extends JpaRepository<TicketFlight, TicketFlightId> {
//    TicketFlight findByTicketAndFlight(Ticket ticket, Flight flight);
    TicketFlight findByTicketFlightId(TicketFlightId ticketFlightId);
}
