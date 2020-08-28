package com.gridnine.testing;

import com.gridnine.testing.developed.predicates.SegmentsRightOrderPredicate;
import com.gridnine.testing.initial.FlightBuilder;
import com.gridnine.testing.initial.Flight;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SegmentsRightOrderPredicateTest {
    @Test
    public void segmentsRightOrderTest() {
        List<Flight> unfilteredFlights = new ArrayList<>();
        Stream.generate(FlightBuilder::createFlights)
                .limit(200)
                .forEach(unfilteredFlights::addAll);

        SegmentsRightOrderPredicate predicate = new SegmentsRightOrderPredicate();
        List<Flight> filteredFlights = unfilteredFlights.stream()
                .filter(predicate)
                .collect(Collectors.toList());

        assertFalse(unfilteredFlights.stream()
                .allMatch(flight -> flight.getSegments()
                        .stream()
                        .allMatch(segment -> segment.getDepartureDate()
                                .isBefore(segment.getArrivalDate()))));

        assertTrue(filteredFlights.stream()
                .allMatch(flight -> flight.getSegments()
                        .stream()
                        .allMatch(segment -> segment.getDepartureDate()
                                .isBefore(segment.getArrivalDate()))));
    }
}
