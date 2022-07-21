package ru.opencode.practice.booking.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.opencode.practice.booking.models.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer> {
}
