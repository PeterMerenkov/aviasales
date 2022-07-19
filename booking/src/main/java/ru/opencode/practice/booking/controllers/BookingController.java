package ru.opencode.practice.booking.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.opencode.practice.booking.models.Booking;
import ru.opencode.practice.booking.models.Ticket;
import ru.opencode.practice.booking.models.helpers.FlightBookingData;
import ru.opencode.practice.booking.models.helpers.TicketBookingData;
import ru.opencode.practice.booking.services.BookingService;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("booking")
@Slf4j
public class BookingController {
    private BookingService service;

    @Autowired
    public BookingController(BookingService service) {
        this.service = service;
    }

    @GetMapping
    public String index() {
        return "";
    }

    @PostMapping
    @Transactional
    public String initData(@RequestBody List<TicketBookingData> dataList) {
        //TODO обработка данных

        double totalPrice = 0;
        for(TicketBookingData tData : dataList) {
            for(FlightBookingData fData : tData.getFlightBookingDataList()) {
                totalPrice += fData.getPrice();
            }
        }

        Booking b = new Booking("refik", new Timestamp(System.currentTimeMillis()), totalPrice);
//        service.createBooking(b);

        List<Ticket> p = service.getTickets();
        log.info(service.getTickets().toString());

//        Ticket t = new Ticket("0006432006731", "1116 105350", "PETER MERENKOV", "{\"phone\": \"+70562351386\"}", b);
//        service.createTicket(t);

        return "redirect:/booking";
    }
}
