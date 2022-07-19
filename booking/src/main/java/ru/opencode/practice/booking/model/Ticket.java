package ru.opencode.practice.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket {
    @Id
    @Column(name = "ticket_no")
    private String number;
    @Column(name = "passenger_id")
    private String passengerId;
    @Column(name = "passenger_name")
    private String passengerName;
    @Type(type = "jsonb")
    @Column(name = "contact_data")
    private ContactData contactData;

    @ManyToOne
    @JoinColumn(name = "book_ref")
    private Booking booking;
}
