package ru.opencode.practice.timetable.model.helpers;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
public class TicketBookingData {
   List<FlightBookingData> flightBookingDataList;

   public TicketBookingData(List<FlightBookingDataProjection> projections) {
      List<FlightBookingData> flightBookingDataList = new LinkedList<>();

      for(FlightBookingDataProjection projection : projections) {
         flightBookingDataList.add(new FlightBookingData(projection));
      }
      this.flightBookingDataList = flightBookingDataList;
   }
}
