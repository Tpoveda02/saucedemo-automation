package org.test.exceptions;

public class ElementNotVisibleException extends AssertionError {
    public ElementNotVisibleException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElementNotVisibleException(String message) {
        super(message);
    }
}