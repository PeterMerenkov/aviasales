package ru.opencode.practice.timetable.model.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.opencode.practice.timetable.model.Aircrafts;
import ru.opencode.practice.timetable.model.Flight;
import ru.opencode.practice.timetable.model.Ticket;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SeatsId implements Serializable {
    private Aircrafts aircraftCode;
    private String seatNo;
}
