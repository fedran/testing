package com.gridnine.testing.developed.predicates;

import com.gridnine.testing.initial.Flight;

public class TimeOnEarthPredicate implements FlightPredicate {
    @Override
    public boolean test(Flight flight) {
        for (int i = 0; i + 1 < flight.getSegments().size(); i++) {
            if (
                    flight.getSegments()
                            .get(i)
                            .getArrivalDate()
                            .isBefore(flight
                                    .getSegments()
                                    .get(i + 1)
                                    .getDepartureDate()
                                    .minusHours(2L))
            ) return false;
        }
        return true;
    }
}
