package ru.opencode.practice.timetable.model.helpers;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class FlightBookingData {
    private Integer flightId;
    private String flightNumber;
    private Timestamp scheduledDeparture;
    private Timestamp scheduledArrival;
    private String departureAirport;
    private String arrivalAirport;

    private String conditions;
    private Double price;

    private Integer boardingNumber;
    private String seatNumber;
}
