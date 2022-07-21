package ru.opencode.practice.timetable.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "flights", schema = "bookings")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Flight {
    @Id
    @Column(name = "flight_id")
    private Integer id;
    @Column(name = "flight_no")
    private String number;
    @Column(name = "scheduled_departure")
    private Timestamp scheduledDeparture;
    @Column(name = "scheduled_arrival")
    private Timestamp scheduledArrival;

    @ManyToOne
    @JoinColumn(name = "departure_airport")
    private Airports departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport")
    private Airports arrivalAirport;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "aircraft_code")
    private Aircrafts aircraftCode;
    @Column(name = "actual_departure")
    private Timestamp actualDeparture;
    @Column(name = "actual_arrival")
    private Timestamp actualArrival;
}
