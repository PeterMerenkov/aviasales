package ru.opencode.practice.timetable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.opencode.practice.timetable.model.Flight;
import ru.opencode.practice.timetable.model.TicketFlight;
import ru.opencode.practice.timetable.model.User;
import ru.opencode.practice.timetable.repos.FlightRepo;
import ru.opencode.practice.timetable.repos.TicketRepo;
import ru.opencode.practice.timetable.repos.UserRepo;
import ru.opencode.practice.timetable.service.AdmineService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdmineService {
    @Autowired
    private FlightRepo flightRepo;
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private UserRepo userRepo;



    @Override
    public List<Flight> searchPlain(String in, String out) {
        List<Flight> searchFlight = flightRepo.findAll().stream().filter(x -> x.getStatus().equals("ok")
                        && x.getArrivalAirport().contains(in)
                        && x.getDepartureAirport().contains(out))
                .collect(Collectors.toList());
        return searchFlight;
    }

    @Override
    public Boolean checkStatusPlainById(long id) {

        return flightRepo.findAll().stream().anyMatch(x -> x.getId().equals(id)
                && x.getStatus().equals("ok"));
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    //Доделать проверку на бронированные билеты
    @Override
    public List<TicketFlight> getFreeTicketPlain(long id) {
        List<TicketFlight> ticketFlights = ticketRepo.findAll().
                stream().
                filter(x -> x.getFlight().getId().equals(id)&&x.getConditions().equals("")).
                collect(Collectors.toList());
        return ticketFlights;
    }

    @Override
    public Flight getFlightByID(long id) {
        return flightRepo.findById(id).get();
    }

    @Override
    public User getUserById(long id) {
        return userRepo.findById(id).get();
    }
}
