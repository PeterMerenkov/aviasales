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
public class Airports {
    @Id
    String airportCode;

    String airportName;

    String city;

    double longitude;

    double latitude;

    String timezone;


}
