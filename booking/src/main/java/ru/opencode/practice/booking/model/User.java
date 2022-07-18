package ru.opencode.practice.booking.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class User {
    @Id
    private long id;
    private String firstName;
    private String secondName;
    private String passportNum;
    private String passportSerial;





}
