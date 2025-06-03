package org.pao;

import org.pao.exceptions.EmptyFileException;
import org.pao.exceptions.InvalidDoubleException;
import org.pao.exceptions.ZeroDivisionException;


public class Client {
    public static void main(String[] args) {
        var calculator = new CalculatorImpl();

        try {
            System.out.println(calculator.add(null, 1.0));
        } catch (Calculator.NullParameterException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(calculator.add(1.0, null));
        } catch (Calculator.NullParameterException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(calculator.add(Double.MAX_VALUE, Double.MAX_VALUE));
        } catch (Calculator.OverflowException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(calculator.add(-Double.MAX_VALUE, -Double.MAX_VALUE));
        } catch (Calculator.UnderflowException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(calculator.divide(null, 1.0));
        } catch (Calculator.NullParameterException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(calculator.divide(1.0, null));
        } catch (Calculator.NullParameterException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(calculator.divide(1.0, 0.0));
        } catch (ZeroDivisionException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(calculator.average(null));
        } catch (Calculator.NullParameterException e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(calculator.average(new Double[0]));
        } catch (Calculator.NullParameterException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(calculator.average(calculator.getValuesFrom("src/test/resources/average.txt")));
        } catch (EmptyFileException | InvalidDoubleException e) {
            System.out.println(e.getMessage());
        }
    }
}