package ru.opencode.practice.booking.models;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import ru.opencode.practice.booking.models.helpers.ContactData;

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
    @Type(type = "com.vladmihalcea.hibernate.type.json.JsonType")
    @Column(name = "contact_data")
    private String contactData;

    @ManyToOne
    @JoinColumn(name = "book_ref")
    private Booking booking;
}
