package com.gridnine.testing;

import com.gridnine.testing.developed.predicates.validation.ValidationException;
import com.gridnine.testing.developed.predicates.validation.Validator;
import com.gridnine.testing.initial.Segment;
import com.gridnine.testing.initial.Flight;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    @Test
    public void validatorNullTest() {
        assertThrows(ValidationException.class, () -> {
            Flight flight = null;
            List<Flight> flights = new ArrayList<>();
            flights.add(flight);

            Validator validator = new Validator();
            flights = flights.stream()
                    .filter(flight1 -> validator.test(flight))
                    .collect(Collectors.toList());
        });
    }

    @Test
    public void nullInSegmentsValidatorTest() {
        assertThrows(ValidationException.class, () -> {
            List<Segment> segmentList = null;
            Flight flight = new Flight(segmentList);
            List<Flight> flights = new ArrayList<>();
            flights.add(flight);

            Validator validator = new Validator();
            flights = flights.stream()
                    .filter(validator)
                    .collect(Collectors.toList());
        });
    }

    @Test
    public void segmentNullValidatorTest() {
        assertThrows(ValidationException.class, () -> {
            Segment segment = null;
            List<Segment> segmentList = new ArrayList<>();
            segmentList.add(segment);

            Flight flight = new Flight(segmentList);
            List<Flight> flights = new ArrayList<>();
            flights.add(flight);

            Validator validator = new Validator();
            flights = flights.stream()
                    .filter(validator)
                    .collect(Collectors.toList());
        });
    }

    @Test
    public void segmentValidatorTest() {
        assertThrows(ValidationException.class, () -> {
            Segment segment = new Segment(LocalDateTime.now(),
                    LocalDateTime.now().minusHours(2L));
            List<Segment> segmentList = new ArrayList<>();
            segmentList.add(segment);

            Flight f = new Flight(segmentList);
            List<Flight> flights = new ArrayList<>();
            flights.add(f);

            Validator validator = new Validator();
            flights = flights.stream()
                    .filter(validator)
                    .collect(Collectors.toList());
        });
    }

    @Test
    public void validatorTest() {
        Segment segment = new Segment(LocalDateTime.now().minusHours(2L),
                LocalDateTime.now());
        List<Segment> segmentList = new ArrayList<>();
        segmentList.add(segment);

        Flight f = new Flight(segmentList);
        List<Flight> flights = new ArrayList<>();
        flights.add(f);

        Validator validator = new Validator();
        List<Flight> newFlights = flights.stream()
                .filter(validator)
                .collect(Collectors.toList());

        assertEquals(newFlights, flights);
    }
}
