package com.gridnine.testing.developed.predicates.validation;

import com.gridnine.testing.developed.predicates.FlightPredicate;
import com.gridnine.testing.initial.Segment;
import com.gridnine.testing.initial.Flight;

import java.util.Objects;

public class Validator implements FlightPredicate {

    @Override
    public boolean test(Flight flight) {
        if (flight == null) {
            throw new ValidationException("Null in arguments of test method");
        } else if (flight.getSegments() == null) {
            throw new ValidationException("Flight segments is null");
        } else if (flight.getSegments()
                .stream()
                .anyMatch(Objects::isNull)) {
            throw new ValidationException("One of flights segment  is null");
        } else if (flight.getSegments()
                .stream()
                .anyMatch(this::segmentValidate)) {
            throw new ValidationException("ArrivalDate is before DepartureDate");
        }
        return true;
    }

    private boolean segmentValidate(Segment segment) {
        return segment.getDepartureDate().isAfter(segment.getArrivalDate());
    }
}
