package com.gridnine.testing;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class AppTest {

    @Test(expected = NullPointerException.class)
    public void sortSegmentNPETest() {
        Sorter sorter = new Sorter();
        List<Flight> flights = sorter.sortSegment(null).collect(Collectors.toList());
    }

    @Test
    public void sortSegmentTest() {
        List<Segment> segmentList = new ArrayList<>();
        Segment segment1 = new Segment(LocalDateTime.now(), LocalDateTime.now());
        segmentList.add(segment1);
        Segment segment2 = new Segment(LocalDateTime.now().minusHours(5L), LocalDateTime.now().minusHours(3L));
        segmentList.add(segment2);
        Segment segment3 = new Segment(LocalDateTime.now().plusHours(2L), LocalDateTime.now().plusHours(3L));
        segmentList.add(segment3);
        Flight flight = new Flight(segmentList);
        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight);

        Sorter sorter = new Sorter();
        List<Flight> flights = sorter.sortSegment(flightList.stream()).collect(Collectors.toList());

        assertEquals(segment2, flight.getSegments().get(0));
        assertEquals(segment1, flight.getSegments().get(1));
        assertEquals(segment3, flight.getSegments().get(2));
    }
}
