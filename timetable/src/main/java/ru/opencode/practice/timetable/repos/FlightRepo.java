package ru.opencode.practice.timetable.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.opencode.practice.timetable.model.Flight;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM bookings.flights WHERE (arrival_airport = (?1)) " +
            "AND (departure_airport = (?1)) AND  (actual_arrival = to_timestamp(?1/1000))")
     List<Flight> getPlain(String in, String out, Timestamp date);

    @Query(nativeQuery = true,value = "SELECT * FROM bookings.flight WHERE id =(?1)")
    Flight chekStatusPlain(long id);
}
