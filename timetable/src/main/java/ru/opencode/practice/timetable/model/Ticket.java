package ru.opencode.practice.timetable.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;


import javax.persistence.*;

@Entity
@Table(name = "tickets", schema = "bookings")
//@TypeDefs(
//        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
//)
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Ticket {
    @Id
    @Column(name = "ticket_no")
    private String number;
    @Column(name = "passenger_id")
    private String passengerId;
    @Column(name = "passenger_name")
    private String passengerName;
//    @Type(type = "com.vladmihalcea.hibernate.type.json.JsonType")
    @Column(name = "contact_data")
    private String contactData;

    @ManyToOne
    @JoinColumn(name = "book_ref")
    private Booking booking;
}
