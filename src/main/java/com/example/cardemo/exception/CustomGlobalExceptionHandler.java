package com.example.cardemo.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomGlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomErrorResponse handleNotFoundException(NotFoundException ex , HttpServletRequest request) {
        return new CustomErrorResponse(404, ex.getMessage(), request.getServletPath());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CustomErrorResponse DataIntegrityViolationException(DataIntegrityViolationException ex , HttpServletRequest request) {
        return new CustomErrorResponse(400, ex.getMessage(), request.getServletPath());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CustomErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        CustomErrorResponse error = new CustomErrorResponse(400, ex.getMessage(), request.getServletPath());
        BindingResult bindingResult = ex.getBindingResult();
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        error.setValidationErrors(validationErrors);
        return error;
    }
}