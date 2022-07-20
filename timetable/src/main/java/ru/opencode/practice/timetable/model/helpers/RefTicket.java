package ru.opencode.practice.timetable.model.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.opencode.practice.timetable.model.TicketFlight;
import ru.opencode.practice.timetable.model.User;

import java.util.List;
@Data
@AllArgsConstructor
public class RefTicket {
    List<User> users;
    List<TicketFlight> ticketFlights;
    double totalPrice;
    int countTicket;

}
