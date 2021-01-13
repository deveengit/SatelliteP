package com.Constellation.satellite.exception;

public class InvalidSatReference extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidSatReference(String errorMessage) {
        super(errorMessage);
    }

}
