package ru.opencode.practice.timetable.model;

import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
=======
import javax.persistence.*;
>>>>>>> 8471d9b3744ced8329886824fcb439f2a9a90e6c

@Entity
@NoArgsConstructor
@Data
<<<<<<< HEAD
@Table(name ="passenger")
=======
@Table(name = "passenger",  schema = "bookings")
>>>>>>> 8471d9b3744ced8329886824fcb439f2a9a90e6c
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
