package ru.opencode.practice.timetable.model.helpers;

import com.sun.istack.NotNull;

public record AirRequest(@NotNull
                         String city,
                         @NotNull
                         String airportCode,
                         @NotNull
                         String arrival_airport,
                         @NotNull
                         String departure_airport,
                         @NotNull
                         String date) {
}
