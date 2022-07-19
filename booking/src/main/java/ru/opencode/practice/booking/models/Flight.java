package ru.opencode.practice.booking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @Column(name = "departure_airport")
    private String departureAirport;
    @Column(name = "arrival_airport")
    private String arrivalAirport;
    @Column(name = "status")
    private String status;
    @Column(name = "aircraft_code")
    private String aircraftCode;
    @Column(name = "actual_departure")
    private Timestamp actualDeparture;
    @Column(name = "actual_arrival")
    private Timestamp actualArrival;
}
