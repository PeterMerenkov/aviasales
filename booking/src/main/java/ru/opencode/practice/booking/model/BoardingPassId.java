package ru.opencode.practice.booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardingPassId implements Serializable {
    private Ticket ticket;
    private Flight flight;
}
