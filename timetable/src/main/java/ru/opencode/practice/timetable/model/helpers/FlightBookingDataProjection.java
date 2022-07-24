package ru.opencode.practice.timetable.model.helpers;

public interface FlightBookingDataProjection {
    Integer getFlight_Id();

    String getConditions();
    Double getPrice();

    String getSeat_Number();
    Integer getBoarding_Number();
}
