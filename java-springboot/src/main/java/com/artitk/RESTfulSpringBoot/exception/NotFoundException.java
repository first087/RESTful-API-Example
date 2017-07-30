package com.artitk.RESTfulSpringBoot.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
