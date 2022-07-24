package ru.opencode.practice.timetable.model.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingData {
    private Integer flight_id;

    private String conditions;
    private Double price;

    private String seat_number;
    private Integer boarding_number;

}
