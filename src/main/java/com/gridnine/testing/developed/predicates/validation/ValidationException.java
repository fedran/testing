package com.gridnine.testing.developed.predicates.validation;

public class ValidationException extends RuntimeException {
    private String s;

    public ValidationException(String s) {
        System.out.println("ValidatorException: " + s + "!");
    }
}
