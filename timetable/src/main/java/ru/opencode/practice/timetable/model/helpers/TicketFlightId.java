package ru.opencode.practice.timetable.model.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.opencode.practice.booking.models.Flight;
import ru.opencode.practice.booking.models.Ticket;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class TicketFlightId implements Serializable {
    private Ticket ticket;
    private Flight flight;
}
