package ru.opencode.practice.booking.models.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.opencode.practice.booking.models.Flight;
import ru.opencode.practice.booking.models.Ticket;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardingPassId implements Serializable {
    private Ticket ticket;
    private Flight flight;
}
