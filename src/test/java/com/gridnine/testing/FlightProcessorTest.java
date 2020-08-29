package com.gridnine.testing;

import com.gridnine.testing.developed.predicates.SegmentsRightOrderPredicate;
import com.gridnine.testing.developed.predicates.AfterCurrentTimePredicate;
import com.gridnine.testing.developed.predicates.TimeOnEarthPredicate;
import com.gridnine.testing.developed.predicates.FlightPredicate;
import com.gridnine.testing.developed.FlightProcessor;
import com.gridnine.testing.initial.FlightBuilder;
import com.gridnine.testing.initial.Flight;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlightProcessorTest {

    @Test
    public void applyPredicatesTest() {
        var predicate1 = new AfterCurrentTimePredicate();
        var predicate2 = new SegmentsRightOrderPredicate();
        var predicate3 = new TimeOnEarthPredicate();

        List<FlightPredicate> predicateList = new ArrayList<>();
        predicateList.add(predicate1);
        predicateList.add(predicate2);
        predicateList.add(predicate3);

        List<Flight> unfilteredFlightList = FlightBuilder.createFlights();

        FlightProcessor flightProcessor = new FlightProcessor(predicateList);

        List<Flight> filteredFlightList = flightProcessor.applyPredicates(unfilteredFlightList.stream())
                .collect(Collectors.toList());

        assertFalse(filteredFlightList.contains(unfilteredFlightList.get(2)));
        assertFalse(filteredFlightList.contains(unfilteredFlightList.get(3)));
        assertFalse(filteredFlightList.contains(unfilteredFlightList.get(4)));

        assertTrue(filteredFlightList.contains(unfilteredFlightList.get(0)));
        assertTrue(filteredFlightList.contains(unfilteredFlightList.get(1)));
        assertTrue(filteredFlightList.contains(unfilteredFlightList.get(5)));
    }

}
