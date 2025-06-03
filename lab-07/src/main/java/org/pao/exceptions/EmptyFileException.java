package org.pao.exceptions;

public class EmptyFileException extends RuntimeException {
    public EmptyFileException() {
        super("Empty file");
    }
}
