package com.gridnine.testing.developed.predicates;

import com.gridnine.testing.initial.Flight;

import java.time.LocalDateTime;

public class AfterCurrentTimePredicate implements FlightPredicate {

    @Override
    public boolean test(Flight flight) {
        return flight.getSegments()
                .get(0)
                .getDepartureDate()
                .isAfter(LocalDateTime.now());
    }
}
