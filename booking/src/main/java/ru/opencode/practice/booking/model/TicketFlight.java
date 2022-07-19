package ru.opencode.practice.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ticket_flights")
@IdClass(TicketFlightId.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketFlight {
    @Id
    @ManyToOne
    @JoinColumn(name = "ticket_no")
    private Ticket ticket;
    @Id
    @OneToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
    @Column(name = "fare_conditions")
    private String conditions;
    @Column(name = "amount")
    private Double price;
}
