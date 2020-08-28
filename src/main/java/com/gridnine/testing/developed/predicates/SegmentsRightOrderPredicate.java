package com.gridnine.testing.developed.predicates;

import com.gridnine.testing.initial.Segment;
import com.gridnine.testing.initial.Flight;

public class SegmentsRightOrderPredicate implements FlightPredicate {
    @Override
    public boolean test(Flight flight) {
        return flight.getSegments()
                .stream()
                .anyMatch(this::isRightOrder);
    }

    private boolean isRightOrder(Segment segment) {
        return segment.getDepartureDate().isBefore(segment.getArrivalDate());
    }
}
