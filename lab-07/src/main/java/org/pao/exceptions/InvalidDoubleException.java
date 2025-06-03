package org.pao.exceptions;

public class InvalidDoubleException extends NumberFormatException {
    public InvalidDoubleException(String value) {
        super(value + " is not a valid double");
    }
}
