package ru.opencode.practice.timetable.service;

import ru.opencode.practice.timetable.model.Flight;
import ru.opencode.practice.timetable.model.TicketFlight;
import ru.opencode.practice.timetable.model.User;

import java.util.List;

public interface AdmineService {
    List<Flight> searchPlain(String in, String out);

    Boolean checkStatusPlainById(long id);

    List<User> getUsers();

    List<TicketFlight> getFreeTicketPlain(long id);

    Flight getFlightByID(long id);

    User getUserById(long id);


}
