package ru.opencode.practice.booking.models.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.opencode.practice.booking.models.Flight;
import ru.opencode.practice.booking.models.Ticket;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class TicketFlightId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "ticket_no")
    private Ticket ticket;
    @OneToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;
}
