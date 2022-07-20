package ru.opencode.practice.timetable.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.opencode.practice.timetable.model.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight,Long> {
}
