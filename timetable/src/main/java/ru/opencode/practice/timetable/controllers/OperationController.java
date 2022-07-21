package ru.opencode.practice.timetable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.opencode.practice.timetable.exception.NoSuchCountExeption;
import ru.opencode.practice.timetable.model.Flight;
import ru.opencode.practice.timetable.model.TicketFlight;
import ru.opencode.practice.timetable.model.User;
import ru.opencode.practice.timetable.model.helpers.AirRequest;
import ru.opencode.practice.timetable.model.helpers.RefTicket;
import ru.opencode.practice.timetable.service.AdmineService;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class OperationController {
    @Autowired
    AdmineService admineService;

    @GetMapping
    public List<User> getUsers() {
        return admineService.getUsers();
    }

    @PostMapping
    @RequestMapping("/{id}")
    public User getUser(@PathVariable long id) {
        return admineService.getUserById(id);
    }

    @PostMapping
    @RequestMapping("/getAirPlain")
    public List<Flight> getAirPlain(@RequestBody AirRequest request) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS Z");
        Date testDate = df.parse(request.date());

        Timestamp ts = new Timestamp(testDate.getTime());
        return admineService.searchPlain(request.arrival_airport(), request.departure_airport(), ts);
    }

    @PostMapping
    @RequestMapping("/getFlightById/{id}")
    public Flight getFlightById(@PathVariable long id) {
        if (admineService.checkStatusPlainById(id))
            return admineService.getFlightByID(id);
        else
            throw new NoSuchCountExeption("Рейс отменен");
    }

    //надо тестить
    @PostMapping
    @RequestMapping("/buyTicket")
    public RefTicket buyTickets(@RequestBody List<User> users,
                                @RequestBody int countTicket,
                                @RequestBody List<TicketFlight> ticketFlight) {
        int totalPrice = ticketFlight.stream().mapToInt(x -> x.getPrice().intValue()).sum();
        return new RefTicket(users, ticketFlight, totalPrice, countTicket);

    }
}
