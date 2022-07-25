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

    public FlightBookingData(FlightBookingDataProjection projection) {
        this.flight_id = projection.getFlight_Id();
        this.conditions = projection.getConditions();
        this.price = projection.getPrice();
        this.seat_number = projection.getSeat_Number();
        this.boarding_number = projection.getBoarding_Number();;
    }
}
