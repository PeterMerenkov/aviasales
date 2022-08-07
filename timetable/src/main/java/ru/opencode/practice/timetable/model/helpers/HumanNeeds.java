package ru.opencode.practice.timetable.model.helpers;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HumanNeeds {

        private String arrival_city;

        private String departure_city;

        private String fare_conditions;

        private int amount;

        private int skip;

}