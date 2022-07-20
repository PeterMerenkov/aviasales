package ru.opencode.practice.timetable.model.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.opencode.practice.timetable.model.Flight;
import ru.opencode.practice.timetable.model.Ticket;


import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardingPassId implements Serializable {
    private Ticket ticket;
    private Flight flight;
}
