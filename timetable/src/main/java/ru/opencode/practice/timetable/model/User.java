package ru.opencode.practice.timetable.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@NoArgsConstructor
@Data
@Table(name = "passenger",  schema = "bookings")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String secondName;
    private String passportNum;
    private String passportSerial;
    private String DateBirth;
}
