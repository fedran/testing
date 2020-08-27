package com.gridnine.testing;

import java.util.stream.Stream;
import java.util.Comparator;
import java.util.Objects;

public class Sorter {

    public Stream<Flight> sortSegment(Stream<Flight> flightStream) {
        if (flightStream == null) throw new NullPointerException("Sorting failed. Null in sortSegment in Arguments");
        else {
            return flightStream.filter(Objects::nonNull).map(flight -> {
                flight.getSegments().sort(Comparator.comparing(Segment::getDepartureDate));
                return flight;
            });
        }


    }
}
