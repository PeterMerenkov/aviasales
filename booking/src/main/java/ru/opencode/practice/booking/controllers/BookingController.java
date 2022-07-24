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
import ru.opencode.practice.booking.models.helpers.ContactData;
import ru.opencode.practice.booking.models.helpers.FlightBookingData;
import ru.opencode.practice.booking.models.helpers.TicketBookingData;
import ru.opencode.practice.booking.models.helpers.TicketFlightId;
import ru.opencode.practice.booking.services.BookingService;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("booking")
@SessionAttributes(value = "dataList")
@Slf4j
public class BookingController {
    private BookingService service;

    @Autowired
    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public String index(@ModelAttribute("dataList") List<TicketBookingData> dataList) {
        System.out.println(dataList);
        System.out.println("test");
        return "";
    }

    @GetMapping
//    @Transactional
    public String initData(@RequestBody List<TicketBookingData> dataList, Model model) {
        //TODO обработка данных

        model.addAttribute("dataList", dataList);

//        double totalPrice = 0;
//        for(TicketBookingData tData : dataList) {
//            for(FlightBookingData fData : tData.getFlightBookingDataList()) {
//                totalPrice += fData.getPrice();
//            }
//        }


//        Booking b = new Booking("refik", new Timestamp(System.currentTimeMillis()), totalPrice);
//        model.addAttribute("booking", b);
//        service.createBooking(b);


//        List<Ticket> p = service.getTickets();
//        log.info(service.getTickets().toString());


//        Ticket t = service.getTicketById("0005432425932");
//        Flight f = service.getFlightById(13287);
//        TicketFlight tf = service.getTicketFlightById(t, f);
//        System.out.println("test");


//        for(TicketBookingData tData : dataList) {
//
//            Ticket t = new Ticket("0006432006731", "1116 105350", "PETER MERENKOV", new ContactData("+79115620522", null), b);
//            service.createTicket(t);
//            for(FlightBookingData fData : tData.getFlightBookingDataList()) {
//                Flight f = service.getFlightById(fData.getFlightId());
//
//                TicketFlight tf = new TicketFlight(new TicketFlightId(t, f), fData.getConditions(), fData.getPrice());
//                service.createTicketFlight(tf);
//            }
//        }

//        for (int i = 0; i < dataList.size(); i++) {
//            TicketBookingData tData = dataList.get(i);
//            String passengerId = "";
//            model.addAttribute("id" + i, passengerId);
//            String passengerName = "";
//            model.addAttribute("name" + i, passengerName);
//
//            model.addAttribute("contactData", new ContactData());
//
//        }




        return "test";
    }
}
