package ru.opencode.practice.booking.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.opencode.practice.booking.models.Booking;
import ru.opencode.practice.booking.models.Ticket;
import ru.opencode.practice.booking.repos.BookingRepo;
import ru.opencode.practice.booking.repos.TicketRepo;

import java.util.List;

@Service
@Slf4j
public class BookingService {
    private BookingRepo repo;
    private TicketRepo ticketRepo;

    @Autowired
    public BookingService(BookingRepo repo, TicketRepo ticketRepo) {
        this.repo = repo;
        this.ticketRepo = ticketRepo;
    }

    public void createBooking(Booking booking) {
        repo.save(booking);
        log.info("Saved booking - {}", booking);
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
}
