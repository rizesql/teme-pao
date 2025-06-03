package org.pao;

import org.pao.exceptions.ZeroDivisionException;

public interface Calculator {
    class NullParameterException extends IllegalArgumentException {
        public NullParameterException() {
            super("Null parameter");
        }
    }

    class OverflowException extends ArithmeticException {
        public OverflowException(Double lhs, Double rhs) {
            super("Overflow: " + lhs + ", " + rhs);
        }
    }

    class UnderflowException extends ArithmeticException {
        public UnderflowException(Double lhs, Double rhs) {
            super("Underflow: " + lhs + ", " + rhs);
        }
    }


    Double add(Double lhs, Double rhs) throws NullParameterException, OverflowException, UnderflowException;

    Double divide(Double lhs, Double rhs) throws NullParameterException, OverflowException, UnderflowException, ZeroDivisionException;

    Double average(Double[] numbers) throws NullParameterException, OverflowException, UnderflowException, ZeroDivisionException;
}
