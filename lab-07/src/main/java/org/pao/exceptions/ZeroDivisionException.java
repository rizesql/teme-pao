package org.pao.exceptions;

public class ZeroDivisionException extends RuntimeException {
    public ZeroDivisionException() {
        super("Cannot divide by zero");
    }
}
