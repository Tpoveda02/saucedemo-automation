package org.test.exceptions;


public class AuthenticationException extends RuntimeException {
    private final String username;

    public AuthenticationException(String username, Throwable cause) {
        super("Authentication failed for user: " + username, cause);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}