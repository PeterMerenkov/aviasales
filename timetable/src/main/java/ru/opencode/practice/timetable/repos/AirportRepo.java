package ru.opencode.practice.timetable.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.opencode.practice.timetable.model.Airports;
import ru.opencode.practice.timetable.model.Flight;

import java.util.List;

@Repository
public interface AirportRepo extends JpaRepository<Airports,Long> {
    @Query(nativeQuery = true, value = "Select * from bookings.Airports WHERE (city= (?1) " +
            "AND (airport_name = (?1)) ")
    List<Airports> serchAirport(String city, String airport_name);

}
