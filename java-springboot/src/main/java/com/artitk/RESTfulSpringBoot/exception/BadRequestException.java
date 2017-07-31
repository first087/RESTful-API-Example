package com.artitk.RESTfulSpringBoot.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
        super();
    }

    public BadRequestException(Throwable cause) {
        super(cause);
    }
}
