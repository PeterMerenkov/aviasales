package ru.opencode.practice.booking.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Booking createBooking(Booking booking) {
        log.info("Saved booking - {}", booking);
        return repo.save(booking);
    }

    public Ticket getTicketById(String number) {
        return ticketRepo.findByNumber(number);
    }

    public Ticket createTicket(Ticket ticket) {
        log.info("Saved ticket - {}", ticket);
        return ticketRepo.save(ticket);
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

    public TicketFlight createTicketFlight(TicketFlight ticketFlight) {
        log.info("Saved TicketFlight - {}", ticketFlight);
        return ticketFlightRepo.save(ticketFlight);
    }

    public String getFreeTicketNum() {
        Long digit = Long.parseLong(ticketRepo.getMaxTicketNum());
        digit++;
        String digitStr = digit.toString();
        int digitLength = 13;

        StringBuilder zeros = new StringBuilder();
        if (digitLength > digitStr.length()) {
            for (int i = 0; i < (digitLength - digitStr.length()); i++) {
                zeros.append("0");
            }
        }


        return zeros + digitStr;
    }

    public String getFreeBookRef() {
        Integer digit = Integer.parseInt(repo.getMaxRef(), 16);
        digit++;
        String digitStr = Integer.toHexString(digit);
        int digitLength = 6;

        StringBuilder zeros = new StringBuilder();
        if (digitLength > digitStr.length()) {
            for (int i = 0; i < (digitLength - digitStr.length()); i++) {
                zeros.append("0");
            }
        }

        return zeros + digitStr;
    }
}
