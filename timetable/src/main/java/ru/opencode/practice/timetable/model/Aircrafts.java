package ru.opencode.practice.timetable.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(schema = "bookings")
public class Aircrafts {
    @Id
    String aircraftCode;

    String model;

    int range;
}
