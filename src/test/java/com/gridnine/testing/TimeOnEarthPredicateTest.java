package com.gridnine.testing;

import com.gridnine.testing.developed.predicates.TimeOnEarthPredicate;
import com.gridnine.testing.initial.Segment;
import com.gridnine.testing.initial.Flight;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeOnEarthPredicateTest {
    @Test
    public void timeOnEarthFilterTest() {
        Segment segment1 = new Segment(LocalDateTime.now(),
                LocalDateTime.now().plusHours(1L));
        Segment segment2 = new Segment(LocalDateTime.now().plusHours(2L),
                LocalDateTime.now().plusHours(3L));
        Segment segment3 = new Segment(LocalDateTime.now().plusHours(6L),
                LocalDateTime.now().plusHours(7L));

        List<Segment> segmentList1 = new ArrayList<>();
        segmentList1.add(segment1);
        segmentList1.add(segment2);
        segmentList1.add(segment3);

        Flight f1 = new Flight(segmentList1);

        Segment segment4 = new Segment(LocalDateTime.now(),
                LocalDateTime.now().plusHours(1L));
        Segment segment5 = new Segment(LocalDateTime.now().plusHours(2L),
                LocalDateTime.now().plusHours(3L));
        Segment segment6 = new Segment(LocalDateTime.now().plusHours(4L),
                LocalDateTime.now().plusHours(7L));

        List<Segment> segmentList2 = new ArrayList<>();
        segmentList2.add(segment4);
        segmentList2.add(segment5);
        segmentList2.add(segment6);

        Flight f2 = new Flight(segmentList2);

        System.out.println(f2);

        List<Flight> flightList = new ArrayList<>();
        flightList.add(f1);
        flightList.add(f2);

        TimeOnEarthPredicate predicate = new TimeOnEarthPredicate();
        flightList = flightList.stream()
                .filter(predicate)
                .collect(Collectors.toList());

        assertFalse(flightList.contains(f1));
        assertTrue(flightList.contains(f2));
    }
}
