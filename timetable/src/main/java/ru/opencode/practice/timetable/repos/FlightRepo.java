package ru.opencode.practice.timetable.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.opencode.practice.timetable.model.Flight;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM  bookings.flights WHERE (arrival_airport = ?1) " +
            "AND (departure_airport = ?2)" +
            " AND  (scheduled_departure BETWEEN ?3 AND ?4)" +
            "AND NOT status = 'Arrived'"
    )
     List<Flight> getPlain(String in, String out, Timestamp firstDateT,Timestamp secondDateT);

    @Query(nativeQuery = true,value = "SELECT * FROM bookings.flights WHERE flight_id = ?1")
    Flight checkStatusPlain(long id);
}
