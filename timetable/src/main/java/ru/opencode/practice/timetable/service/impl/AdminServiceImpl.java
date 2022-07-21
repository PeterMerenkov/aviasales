package ru.opencode.practice.timetable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.opencode.practice.timetable.model.Airports;
import ru.opencode.practice.timetable.model.Flight;
import ru.opencode.practice.timetable.model.TicketFlight;
import ru.opencode.practice.timetable.model.User;
import ru.opencode.practice.timetable.repos.AirportRepo;
import ru.opencode.practice.timetable.repos.FlightRepo;
import ru.opencode.practice.timetable.repos.TicketRepo;
import ru.opencode.practice.timetable.repos.UserRepo;
import ru.opencode.practice.timetable.service.AdmineService;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    @Autowired
    private AirportRepo airportRepo;


    @Override
    public List<Flight> searchPlain(String in, String out, String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date firstDate = df.parse(date);

        Calendar c = Calendar.getInstance();
        c.setTime(firstDate);
        c.add(Calendar.DATE, 1);
        String output = df.format(c.getTime());
        Date secondDate = df.parse(output);

        Timestamp firstDateT = new Timestamp(firstDate.getTime());
        Timestamp secondDateT = new Timestamp(secondDate.getTime());

        return flightRepo.getPlain(in, out, firstDateT, secondDateT);
    }

    @Override
    public Boolean checkStatusPlainById(long id) {
        if (!flightRepo.checkStatusPlain(id).getStatus().equals("Arrived"))
            return true;
        else return false;
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
                filter(x -> x.getFlight().getId().equals(id) && x.getConditions().equals("")).
                collect(Collectors.toList());
        return ticketFlights;
    }

    @Override
    public Flight getFlightByID(long id) {
        return flightRepo.checkStatusPlain(id);
    }

    @Override
    public User getUserById(long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<Airports> serchAirport(String city, String airport_name) {
        return airportRepo.serchAirport(city,airport_name);
    }
}
