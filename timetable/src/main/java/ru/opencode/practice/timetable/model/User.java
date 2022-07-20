package ru.opencode.practice.timetable.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@Table(name ="passenger")
public class User {
    @Id
    private long id;
    private String firstName;
    private String secondName;
    private String passportNum;
    private String passportSerial;
    private String DateBirth;





}
