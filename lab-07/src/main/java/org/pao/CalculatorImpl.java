package org.pao;

import org.pao.exceptions.EmptyFileException;
import org.pao.exceptions.InvalidDoubleException;
import org.pao.exceptions.ZeroDivisionException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class CalculatorImpl implements Calculator {

    @Override
    public Double add(Double lhs, Double rhs) throws NullParameterException, OverflowException, UnderflowException {
        if (lhs == null || rhs == null) throw new NullParameterException();

        var res = lhs + rhs;
        if (res == Double.NEGATIVE_INFINITY) throw new UnderflowException(lhs, rhs);
        if (res == Double.POSITIVE_INFINITY) throw new OverflowException(lhs, rhs);

        return res;
    }

    @Override
    public Double divide(Double lhs, Double rhs) throws NullParameterException, OverflowException, UnderflowException, ZeroDivisionException {
        if (lhs == null || rhs == null) throw new NullParameterException();
        if (rhs == 0.0) throw new ZeroDivisionException();

        var res = lhs / rhs;
        if (res == Double.NEGATIVE_INFINITY) throw new UnderflowException(lhs, rhs);
        if (res == Double.POSITIVE_INFINITY) throw new OverflowException(lhs, rhs);

        return res;
    }

    @Override
    public Double average(Double[] numbers) throws NullParameterException, OverflowException, UnderflowException, ZeroDivisionException {
        if (numbers == null || numbers.length == 0) throw new NullParameterException();

        var sum = Arrays.stream(numbers).reduce(0.0, this::add);

        return divide(sum, (double) numbers.length);
    }

    public Double[] getValuesFrom(String file) throws EmptyFileException, InvalidDoubleException {
        try (var reader = Files.newBufferedReader(Path.of(file))) {
            var line = reader.readLine();
            if (line == null) throw new EmptyFileException();

            line = line.trim();
            if (line.isEmpty()) throw new EmptyFileException();

            return Arrays.stream(line.split("\\s+")).map(Double::parseDouble).toArray(Double[]::new);
        } catch (NumberFormatException e) {
            throw new InvalidDoubleException(e.getMessage());
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
}
