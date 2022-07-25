package ru.opencode.practice.timetable.service;

import org.springframework.stereotype.Service;
import ru.opencode.practice.timetable.model.Airports;
import ru.opencode.practice.timetable.model.Flight;
import ru.opencode.practice.timetable.model.TicketFlight;
import ru.opencode.practice.timetable.model.User;
import ru.opencode.practice.timetable.model.helpers.FlightBookingData;
import ru.opencode.practice.timetable.model.helpers.FlightBookingDataProjection;
import ru.opencode.practice.timetable.model.helpers.PersonTicketView;
import ru.opencode.practice.timetable.model.helpers.TicketBookingData;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

@Service
public interface AdmineService {
    List<Flight> searchPlain(String in, String out, String date) throws ParseException;

    Boolean checkStatusPlainById(long id);

    List<User> getUsers();

    List<TicketFlight> getFreeTicketPlain(long id);

    Flight getFlightByID(long id);

    User getUserById(long id);
    List<Airports> serchAirport(String city, String airport_name);

    List<PersonTicketView> takeFlights(String arrivalCity, String departureCity, String fareConditions, int amount, int skip);
}
