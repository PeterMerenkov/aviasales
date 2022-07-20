package ru.opencode.practice.timetable.model.helpers;

import lombok.Data;

import java.util.List;

@Data
public class TicketBookingData {
    List<FlightBookingData> flightBookingDataList;
}
