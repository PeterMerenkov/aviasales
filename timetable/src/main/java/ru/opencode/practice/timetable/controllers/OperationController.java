package ru.opencode.practice.timetable.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.opencode.practice.timetable.exception.NoSuchCountExeption;
import ru.opencode.practice.timetable.model.Flight;
import ru.opencode.practice.timetable.model.User;
import ru.opencode.practice.timetable.service.AdmineService;

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
    List<Flight> getAirPlain(@PathVariable String in,
                             @PathVariable String out) {
        return admineService.searchPlain(in, out);

    }

    @PostMapping
    Flight getFlightById(@PathVariable long id) {
        if (admineService.checkStatusPlainById(id))
            return admineService.getFlightByID(id);
        else
             throw new NoSuchCountExeption("Рейс отменен");
    }

}
