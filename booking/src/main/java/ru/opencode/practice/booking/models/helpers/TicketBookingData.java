package ru.opencode.practice.booking.models.helpers;

import lombok.Data;
import ru.opencode.practice.booking.models.helpers.FlightBookingData;

import java.util.List;

@Data
public class TicketBookingData {
    private List<FlightBookingData> flightBookingDataList;
}
