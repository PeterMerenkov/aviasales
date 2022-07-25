package ru.opencode.practice.booking.models.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingData {
    private Integer flightId;

    private String conditions;
    private Double price;

    private Integer boardingNumber;
    private String seatNumber;
}
