package com.gridnine.testing.developed;

import com.gridnine.testing.developed.predicates.FlightPredicate;
import com.gridnine.testing.initial.Flight;

import java.util.stream.Stream;
import java.util.List;

public class FlightProcessor {
    private final List<FlightPredicate> flightPredicates;

    public FlightProcessor(List<FlightPredicate> flightPredicates) {
        this.flightPredicates = flightPredicates;
    }

    public Stream<Flight> applyPredicates(Stream<Flight> flightStream) {
        for (int i = 0; i < flightPredicates.size(); i++) {
            flightStream = flightStream.filter(flightPredicates.get(i));
        }
        return flightStream;
    }
}
