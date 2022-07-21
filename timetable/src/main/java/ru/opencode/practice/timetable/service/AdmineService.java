package ru.opencode.practice.timetable.service;

import org.springframework.stereotype.Service;
import ru.opencode.practice.timetable.model.Flight;
import ru.opencode.practice.timetable.model.TicketFlight;
import ru.opencode.practice.timetable.model.User;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.List;

@Service
public interface AdmineService {
    List<Flight> searchPlain(String in, String out, Timestamp date);

    Boolean checkStatusPlainById(long id);

    List<User> getUsers();

    List<TicketFlight> getFreeTicketPlain(long id);

    Flight getFlightByID(long id);

    User getUserById(long id);


}
