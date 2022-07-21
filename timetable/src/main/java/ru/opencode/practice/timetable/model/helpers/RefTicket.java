package ru.opencode.practice.timetable.model.helpers;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.opencode.practice.timetable.model.Flight;
import ru.opencode.practice.timetable.model.TicketFlight;
import ru.opencode.practice.timetable.model.User;

import java.util.List;

public record RefTicket(
        @NotNull
        String countUser,
        @NotNull
        List<User> users,
        @NotNull
        List<TicketFlight> ticketFlights,
        @NotNull
        Flight flight
) {

}
