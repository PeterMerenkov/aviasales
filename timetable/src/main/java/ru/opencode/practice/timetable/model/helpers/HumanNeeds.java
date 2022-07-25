package ru.opencode.practice.timetable.model.helpers;

import com.sun.istack.NotNull;

public record HumanNeeds(
        @NotNull
        String arrival_city,
        @NotNull
        String departure_city,
        @NotNull
        String fare_conditions,

        @NotNull
        int amount,

        @NotNull
        int skip) {
}