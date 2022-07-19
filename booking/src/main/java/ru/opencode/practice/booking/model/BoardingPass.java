package ru.opencode.practice.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "boarding_passes")
@IdClass(BoardingPassId.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardingPass {
    @Id
    @ManyToOne
    @JoinColumn(name = "ticket_no")
    private Ticket ticket;
    @Id
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
    @Column(name = "boarding_no")
    private Integer boardingNumber;
    @Column(name = "seat_no")
    private String seatNumber;
}
