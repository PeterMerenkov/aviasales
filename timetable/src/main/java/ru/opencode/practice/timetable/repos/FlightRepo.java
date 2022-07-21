package ru.opencode.practice.timetable.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.opencode.practice.timetable.model.Flight;

import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {
    @Query(nativeQuery = true, value = "Select * from Flight WHERE (arrival_airport = (?1) " +
            "AND (arrival_airport = (?1)) AND  (actual_arrival = (?1)))")
     List<Flight> getPlain(String in,String out,String date);

    @Query(nativeQuery = true,value = "SELECT * from Flight where id =(?1)")
    Flight chekStatusPlain(long id);
}
