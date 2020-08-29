package com.gridnine.testing.developed.predicates;

import com.gridnine.testing.initial.Flight;

import java.time.LocalDateTime;

public class TimeOnEarthPredicate implements FlightPredicate {
    @Override
    public boolean test(Flight flight) {
        for (int i = 0; i + 1 < flight.getSegments().size(); i++) {
            LocalDateTime arrDate = flight.getSegments()
                    .get(i)
                    .getArrivalDate();
            LocalDateTime depDate = flight.getSegments()
                    .get(i + 1)
                    .getDepartureDate()
                    .minusHours(2L);
            if (arrDate.isBefore(depDate)) return false;
        }
        return true;
    }
}
