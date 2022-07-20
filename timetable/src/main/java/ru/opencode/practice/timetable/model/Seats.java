package ru.opencode.practice.timetable.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.opencode.practice.timetable.model.helpers.BoardingPassId;
import ru.opencode.practice.timetable.model.helpers.SeatsId;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@IdClass(SeatsId.class)
@Table(schema = "bookings")
public class Seats {
    @Id
    @ManyToOne
    @JoinColumn(name = "aircraft_code")
    Aircrafts aircraftCode;

    @Id
    String seatNo;

    String fareConditions;

}
