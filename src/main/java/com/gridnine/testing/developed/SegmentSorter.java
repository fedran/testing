package com.gridnine.testing.developed;

import com.gridnine.testing.initial.Segment;
import com.gridnine.testing.initial.Flight;

import java.util.stream.Stream;
import java.util.Comparator;
import java.util.Objects;


public class SegmentSorter {

    public Stream<Flight> sortSegment(Stream<Flight> flightStream) {
        return flightStream.filter(Objects::nonNull).map(flight -> {
            flight.getSegments()
                    .sort(Comparator.comparing(Segment::getDepartureDate));
            return flight;
        });
    }
}
