package ru.opencode.practice.booking.models.helpers;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class FlightBookingData {
    private Integer flightId;

    private String conditions;
    private Double price;

    private Integer boardingNumber;
    private String seatNumber;
}
