package org.test.exceptions;


public class MessageContentMismatchException extends AssertionError {
    public MessageContentMismatchException(String expected, String actual) {
        super("Expected message to contain: '" + expected + "', but found: '" + actual + "'.");
    }
}
