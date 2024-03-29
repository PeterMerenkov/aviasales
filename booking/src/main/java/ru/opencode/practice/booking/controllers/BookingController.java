package ru.opencode.practice.booking.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.opencode.practice.booking.models.Booking;
import ru.opencode.practice.booking.models.Flight;
import ru.opencode.practice.booking.models.Ticket;
import ru.opencode.practice.booking.models.TicketFlight;
import ru.opencode.practice.booking.models.helpers.*;
import ru.opencode.practice.booking.services.BookingService;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("booking")
@SessionAttributes(value = "dataList")
@Slf4j
public class BookingController {
    private final BookingService service;

    @Autowired
    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping("test")
    public String index(@ModelAttribute("dataList") List<TicketBookingData> dataList,
                        @ModelAttribute("contactData") ContactDataWrapper cdw, Model model) {

        double totalPrice = 0;
        for(TicketBookingData tData : dataList) {
            for(FlightBookingData fData : tData.getFlightBookingDataList()) {
                totalPrice += fData.getPrice();
            }
        }

        Booking booking = new Booking(service.getFreeBookRef(), new Timestamp(System.currentTimeMillis()), totalPrice);
        service.createBooking(booking);

        //------------------------------------------------------------------------------------------
        List<Ticket> tickets = new LinkedList<>();
        List<TicketFlight> ticketFlights= new LinkedList<>();
        for (int i = 0; i < dataList.size(); i++) {
            TicketBookingData tData = dataList.get(i);

            Ticket ticket = new Ticket(
                    service.getFreeTicketNum(),
                    cdw.getPassengerIdList().get(i),
                    cdw.getPassengerNameList().get(i),
                    cdw.getContactDataList().get(i),
                    booking
            );
            tickets.add(service.createTicket(ticket));

            for (FlightBookingData fData : tData.getFlightBookingDataList()) {
                Flight flight = service.getFlightById(fData.getFlightId());

                TicketFlight tf = new TicketFlight(
                        new TicketFlightId(ticket, flight),
                        fData.getConditions(),
                        fData.getPrice()
                );
                ticketFlights.add(service.createTicketFlight(tf));
            }
        }
        model.addAttribute("tickets", tickets);
        model.addAttribute("ticketFlights", ticketFlights);
        return "result.html";
    }

    @PostMapping
    public String initData(@RequestBody List<TicketBookingData> dataList, Model model) {

        model.addAttribute("dataList", dataList);


        List<ContactData> contactData = new ArrayList<>();
        List<String> passengerIdList = new ArrayList<>();
        List<String> passengerNameList = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            contactData.add(new ContactData());
            passengerIdList.add("");
            passengerNameList.add("");
        }
        ContactDataWrapper cdw = new ContactDataWrapper(contactData, passengerIdList, passengerNameList);

        model.addAttribute("contactData", cdw);

        return "test";
    }
}
