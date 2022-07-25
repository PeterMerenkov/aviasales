package ru.opencode.practice.timetable.model.helpers;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PersonTicketView {
    List<TicketBookingData> tickets;

    private Double totalPrice;

    private String allSeat_number;

    public PersonTicketView(List<TicketBookingData> tickets){
        Double totalPrice = 0.0;
        StringBuilder allSeat_number = new StringBuilder();

        for (TicketBookingData ticket: tickets) {
                for(FlightBookingData flight: ticket.flightBookingDataList) {
                    totalPrice = totalPrice + flight.getPrice();
                    allSeat_number.append(flight.getSeat_number()).append(", ");
                }
        }
        allSeat_number.delete(allSeat_number.length()-2, allSeat_number.length());
        this.totalPrice = totalPrice;
        this.allSeat_number = allSeat_number.toString();
        this.tickets = tickets;
    }

}
