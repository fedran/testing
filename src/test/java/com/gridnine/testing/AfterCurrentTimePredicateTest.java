package com.gridnine.testing;

import org.junit.jupiter.api.Test;
import com.gridnine.testing.initial.Flight;
import com.gridnine.testing.initial.FlightBuilder;
import com.gridnine.testing.developed.predicates.AfterCurrentTimePredicate;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AfterCurrentTimePredicateTest {

    @Test
    public void testTest() {
        List<Flight> unfilteredFlights = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            List<Flight> list = FlightBuilder.createFlights();
            unfilteredFlights.addAll(list);
        }

        Predicate<Flight> predicate = new AfterCurrentTimePredicate();
        List<Flight> filteredFlights = unfilteredFlights.stream()
                .filter(predicate)
                .collect(Collectors.toList());

        assertFalse(unfilteredFlights.stream()
                .allMatch(flight -> flight.getSegments()
                        .get(0)
                        .getDepartureDate()
                        .isAfter(LocalDateTime.now())));
        assertTrue(filteredFlights.stream()
                .allMatch(flight -> flight.getSegments()
                        .get(0)
                        .getDepartureDate()
                        .isAfter(LocalDateTime.now())));
    }
}
