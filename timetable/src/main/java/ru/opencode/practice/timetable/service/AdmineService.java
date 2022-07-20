package ru.opencode.practice.timetable.service;

import org.springframework.stereotype.Service;
import ru.opencode.practice.timetable.model.Flight;
import ru.opencode.practice.timetable.model.TicketFlight;
import ru.opencode.practice.timetable.model.User;

import java.util.List;
<<<<<<< HEAD
=======

>>>>>>> 8471d9b3744ced8329886824fcb439f2a9a90e6c
@Service
public interface AdmineService {
    List<Flight> searchPlain(String in, String out,String date);

    Boolean checkStatusPlainById(long id);

    List<User> getUsers();

    List<TicketFlight> getFreeTicketPlain(long id);

    Flight getFlightByID(long id);

    User getUserById(long id);


}
