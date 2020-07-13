package com.artitk.restful.controller;

import com.artitk.restful.exception.BadRequestException;
import com.artitk.restful.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ExceptionHandleController {
    @ExceptionHandler({MethodArgumentTypeMismatchException.class, BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleBadRequest(Exception e) {
        e.printStackTrace();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNotFound(Exception e) {
        e.printStackTrace();
    }
}
