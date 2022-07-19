package ru.opencode.practice.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Booking {
    @Id
    @Column(name = "book_ref")
    private String ref;
    @Column(name = "book_date")
    private Timestamp date;
    @Column(name = "total_amount")
    private Double totalAmount;
}
/*
*   Мне должно прийти:
* Дата, Цена для полей <Bookings>(book_date, total_amount)
* Кол-во билетов <Tickets count()>
* Перелеты в каждом билете для полей <Ticket_flights>(flight_id, fare_conditions, amount)
* Места в каждом перелете для полей <Boarding_passes>(boarding_no, seat_no)
*
*
*   Я должен дополнить это:
* Данные о каждом пассажире (Tickets - passenger_id, passenger_name, contact_data)
* И все это добавить в базу (Работа с 4 таблицами Bookings, Tickets, Ticket_flights, Boarding passes)
* */