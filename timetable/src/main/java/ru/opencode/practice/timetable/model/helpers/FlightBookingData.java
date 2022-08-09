package ru.opencode.practice.timetable.model.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingData {
    private Integer flightId;

    private String conditions;
    private Double price;

    private String seatNumber;
    private Integer boardingNumber;

    public FlightBookingData(FlightBookingDataProjection projection) {
        this.flightId = projection.getFlight_Id();
        this.conditions = projection.getConditions();
        this.price = projection.getPrice();
        this.seatNumber = projection.getSeat_Number();
        this.boardingNumber = projection.getBoarding_Number();;
    }
}
