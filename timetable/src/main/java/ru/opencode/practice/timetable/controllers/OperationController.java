package ru.opencode.practice.timetable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.opencode.practice.timetable.exception.NoSuchCountExeption;
import ru.opencode.practice.timetable.model.Flight;
import ru.opencode.practice.timetable.model.TicketFlight;
import ru.opencode.practice.timetable.model.User;
import ru.opencode.practice.timetable.model.helpers.*;
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
        return admineService.searchPlain(request.arrival_airport(), request.departure_airport(), request.date());
    }

    @GetMapping
    @RequestMapping("/getFlightById/{id}")
    public Flight getFlightById(@PathVariable long id) {
        if (admineService.checkStatusPlainById(id))
            return admineService.getFlightByID(id);
        else
            throw new NoSuchCountExeption("Рейс закончен");
    }
}
