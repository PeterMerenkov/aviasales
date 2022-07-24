package ru.opencode.practice.booking.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.opencode.practice.booking.models.Booking;
import ru.opencode.practice.booking.models.Flight;
import ru.opencode.practice.booking.models.Ticket;
import ru.opencode.practice.booking.models.TicketFlight;
import ru.opencode.practice.booking.models.helpers.TicketFlightId;
import ru.opencode.practice.booking.repos.BookingRepo;
import ru.opencode.practice.booking.repos.FlightRepo;
import ru.opencode.practice.booking.repos.TicketFlightRepo;
import ru.opencode.practice.booking.repos.TicketRepo;

import java.util.List;

@Service
@Slf4j
public class BookingService {
    private BookingRepo repo;
    private TicketRepo ticketRepo;
    private FlightRepo flightRepo;
    private TicketFlightRepo ticketFlightRepo;

    @Autowired
    public BookingService(BookingRepo repo, TicketRepo ticketRepo, FlightRepo flightRepo, TicketFlightRepo ticketFlightRepo) {
        this.repo = repo;
        this.ticketRepo = ticketRepo;
        this.flightRepo = flightRepo;
        this.ticketFlightRepo = ticketFlightRepo;
    }

    public void createBooking(Booking booking) {
        repo.save(booking);
        log.info("Saved booking - {}", booking);
    }

    public Ticket getTicketById(String number) {
        return ticketRepo.findByNumber(number);
    }

    public void createTicket(Ticket ticket) {
        ticketRepo.save(ticket);
        log.info("Saved ticket - {}", ticket);
    }

    public List<Ticket> getTickets() {
        Pageable limit = PageRequest.of(0,10);
//        return ticketRepo.findAll(limit);
        return ticketRepo.findTopByOrderByNumberDesc();
    }

    public Flight getFlightById(Integer flightId) {
        return flightRepo.findById(flightId).get();
    }

    public TicketFlight getTicketFlightById(Ticket ticket, Flight flight) {
//        return ticketFlightRepo.findByTicketAndFlight(ticket, flight);
        return ticketFlightRepo.findByTicketFlightId(new TicketFlightId(ticket, flight));
    }

    public void createTicketFlight(TicketFlight ticketFlight) {
        ticketFlightRepo.save(ticketFlight);
        log.info("Saved TicketFlight - {}", ticketFlight);
    }
}
