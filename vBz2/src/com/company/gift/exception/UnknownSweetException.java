package com.company.gift.exception;

public class UnknownSweetException extends Exception{
    public UnknownSweetException() {
    }

    public UnknownSweetException(String message) {
        super(message);
    }

    public UnknownSweetException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownSweetException(Throwable cause) {
        super(cause);
    }

    public UnknownSweetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
