package com.gridnine.testing;

import com.gridnine.testing.developed.predicates.SegmentsRightOrderPredicate;
import com.gridnine.testing.developed.predicates.AfterCurrentTimePredicate;
import com.gridnine.testing.developed.predicates.TimeOnEarthPredicate;
import com.gridnine.testing.developed.predicates.validation.Validator;
import com.gridnine.testing.developed.predicates.FlightPredicate;
import com.gridnine.testing.developed.FlightProcessor;
import com.gridnine.testing.developed.SegmentSorter;
import com.gridnine.testing.initial.FlightBuilder;
import com.gridnine.testing.initial.Flight;

import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /**
         * Exclusion of flights from the test set
         * if departure before the current time
         */
        System.out.println("Task 1:");
        List<Flight> testSet = FlightBuilder.createFlights();

        var segmentSorter = new SegmentSorter();
        var validator = new Validator();
        var predicate1 = new AfterCurrentTimePredicate();

        List<FlightPredicate> flightPredicates = new ArrayList<>();
        flightPredicates.add(predicate1);
        flightPredicates.add(validator);

        var processor = new FlightProcessor(flightPredicates);

        Stream<Flight> pipeline1 = testSet.stream();
        pipeline1 = segmentSorter.sortSegment(pipeline1);
        processor.applyPredicates(pipeline1)
                .forEach(System.out::println);

        /**
         * Exclusion of flights from the test set
         * if there are segments with an arrival date earlier
         * than the departure date
         */
        System.out.println("Task 2:");
        var predicate2 = new SegmentsRightOrderPredicate();

        flightPredicates = new ArrayList<>();
        flightPredicates.add(predicate2);
        flightPredicates.add(validator);

        processor = new FlightProcessor(flightPredicates);

        Stream<Flight> pipeline2 = testSet.stream();
        pipeline2 = segmentSorter.sortSegment(pipeline2);
        processor.applyPredicates(pipeline2)
                .forEach(System.out::println);

        /**
         * Exclusion of flights from the test set
         * if the total time spent on the ground
         * exceeds two hours
         */
        System.out.println("Task 3:");
        var predicate3 = new TimeOnEarthPredicate();

        flightPredicates = new ArrayList<>();
        flightPredicates.add(predicate3);
        flightPredicates.add(validator);

        processor = new FlightProcessor(flightPredicates);

        Stream<Flight> pipeline3 = testSet.stream();
        pipeline3 = segmentSorter.sortSegment(pipeline3);
        processor.applyPredicates(pipeline3)
                .forEach(System.out::println);
    }
}
