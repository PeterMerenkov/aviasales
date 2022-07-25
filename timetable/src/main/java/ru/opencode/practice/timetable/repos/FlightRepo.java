package ru.opencode.practice.timetable.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.opencode.practice.timetable.model.Flight;
import ru.opencode.practice.timetable.model.helpers.FlightBookingData;
import ru.opencode.practice.timetable.model.helpers.FlightBookingDataProjection;

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

    @Query(nativeQuery = true, value = "WITH findarrivalAirport AS \n" +
            "(SELECT a.airport_code FROM bookings.airports a WHERE a.city = ?1),\n" +
            "findepartureAirport  AS\n" +
            "(SELECT a.airport_code FROM bookings.airports a WHERE a.city = ?2),\n" +
            "takeflight AS\n" +
            "(SELECT f.flight_id, f.aircraft_code FROM  bookings.flights f, findarrivalAirport faa, findepartureAirport fda\n" +
            "WHERE arrival_airport = faa.airport_code \n" +
            "AND departure_airport = fda.airport_code\n" +
            "AND status = 'Scheduled'),\n" +
            "boardpassByFligthId AS\n" +
            "(SELECT bp.flight_id, bp.boarding_no, bp.seat_no, tfi.aircraft_code  FROM bookings.boarding_passes bp JOIN takeflight tfi on bp.flight_id = tfi.flight_id ),\n" +
            "boardpassNum AS \n" +
            "(SELECT count(bbfi.boarding_no), tfi.flight_id FROM boardpassByFligthId bbfi FULL JOIN takeflight tfi ON bbfi.flight_id = tfi.flight_id\n" +
            "where tfi.flight_id IS NOT NULL   GROUP BY  tfi.flight_id),\n" +
            "aircraftSeats AS\n" +
            "(SELECT s.seat_no, s.fare_conditions, s.aircraft_code, tf.flight_id  FROM bookings.seats s, takeflight tf WHERE s.aircraft_code = tf.aircraft_code AND s.fare_conditions = ?3),\n" +
            "freeSeats AS \n" +
            "(SELECT afs.*  FROM aircraftSeats afs FULL JOIN\n" +
            "boardpassByFligthId bpf on afs.seat_no = bpf.seat_no AND afs.aircraft_code = bpf.aircraft_code AND afs.flight_id = bpf.flight_id WHERE bpf.seat_no IS NULL),\n" +
            "ticketInfo AS \n" +
            "(SELECT seat_no, AVG(COALESCE(amount, 5000)), COALESCE(tf2.fare_conditions, ?3) fare_conditions, fss.flight_id from bookings.ticket_flights tf2 FULL JOIN freeSeats fss\n" +
            "ON tf2.flight_id = fss.flight_id AND tf2.fare_conditions = fss.fare_conditions GROUP BY seat_no, tf2.fare_conditions, fss.flight_id ORDER BY  seat_no ASC),\n" +
            "resultable AS\n" +
            "(SELECT  ti.flight_id, ti.seat_no AS seat_number, ti.AVG AS price, ti.fare_conditions AS conditions, bpn.count AS boarding_number   \n" +
            "FROM ticketInfo ti JOIN boardpassNum bpn ON ti.flight_id = bpn.flight_id),\n" +
            "limitedresultable AS\n" +
            "(\n" +
            "  SELECT flight_id, seat_number, price, conditions, boarding_number,\n" +
            "    ROW_NUMBER() OVER(\n" +
            "      PARTITION BY flight_id\n" +
            "      ORDER BY seat_number DESC, price DESC) AS rownum\n" +
            "  FROM resultable\n" +
            "),\n" +
            "test AS \n" +
            "(SELECT flight_id\n" +
            "FROM limitedresultable GROUP BY flight_id HAVING  count(flight_id) >= ?4)\n" +
            "SELECT lrt.flight_id, lrt.seat_number, lrt.price, lrt.conditions, (lrt.boarding_number + lrt.rownum) AS boarding_number\n" +
            "FROM limitedresultable lrt,  test t WHERE rownum <= ?4 AND lrt.flight_id = t.flight_id\n" +
            "ORDER BY flight_id ASC, seat_number ASC, price ASC limit 5*?4 OFFSET ?5")
    List<FlightBookingDataProjection> flights(String arrivalCity,
                                              String departureCity,
                                              String fareConditions,
                                              int amount,
                                              int skip);

}
