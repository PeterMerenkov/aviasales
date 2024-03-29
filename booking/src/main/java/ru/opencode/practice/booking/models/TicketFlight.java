package ru.opencode.practice.booking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.opencode.practice.booking.models.helpers.TicketFlightId;

import javax.persistence.*;

@Entity
@Table(name = "ticket_flights", schema = "bookings")
//@IdClass(TicketFlightId.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class TicketFlight {
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "ticket_no")
//    private Ticket ticket;
//    @Id
//    @OneToOne
//    @JoinColumn(name = "flight_id")
//    private Flight flight;

    @EmbeddedId
    TicketFlightId ticketFlightId;
    @Column(name = "fare_conditions")
    private String conditions;
    @Column(name = "amount")
    private Double price;
}
