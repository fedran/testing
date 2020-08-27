package com.gridnine.testing;

import com.gridnine.testing.initial.Flight;
import com.gridnine.testing.initial.Segment;
import com.gridnine.testing.developed.SegmentSorter;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void sortSegmentTest() {
        List<Segment> segmentList1 = new ArrayList<>();
        List<Flight> flights = new ArrayList<>();
        SegmentSorter segmentSorter = new SegmentSorter();

        flights = segmentSorter.sortSegment(flights.stream())
                .collect(Collectors.toList());

        assertTrue(flights.isEmpty());

        Segment segment1 = new Segment(LocalDateTime.now(),
                LocalDateTime.now());
        segmentList1.add(segment1);

        Flight flight1 = new Flight(segmentList1);
        flights.add(flight1);

        flights = segmentSorter.sortSegment(flights.stream())
                .collect(Collectors.toList());

        assertTrue(flights.get(0).getSegments().contains(segment1));

        List<Segment> segmentList2 = new ArrayList<>();
        Segment segment2 = new Segment(LocalDateTime.now().minusHours(5L),
                LocalDateTime.now().minusHours(3L));
        Segment segment3 = new Segment(LocalDateTime.now().plusHours(2L),
                LocalDateTime.now().plusHours(3L));
        Segment segment4 = new Segment(LocalDateTime.now().plusHours(7L),
                LocalDateTime.now().plusHours(9L));
        segmentList2.add(segment4);
        segmentList2.add(segment2);
        segmentList2.add(segment3);

        Flight flight2 = new Flight(segmentList2);
        flights.add(flight2);

        flights = segmentSorter.sortSegment(flights.stream())
                .collect(Collectors.toList());

        System.out.println(flights);
        assertEquals(segment1, flights.get(0).getSegments().get(0));
        assertEquals(segment2, flights.get(1).getSegments().get(0));
        assertEquals(segment3, flights.get(1).getSegments().get(1));
        assertEquals(segment4, flights.get(1).getSegments().get(2));
    }
}
