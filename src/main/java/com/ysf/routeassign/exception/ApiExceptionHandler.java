package com.ysf.routeassign.exception;

import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });


        return new ResponseEntity<>(new ValidationException(errors),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {PSQLException.class})
    public ResponseEntity<Object> handlePSQLExceptions(PSQLException ex) {
        return new ResponseEntity<>(new ApiException(Objects.requireNonNull(ex.getServerErrorMessage()).getDetail(),HttpStatus.BAD_REQUEST,null),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleOtherExceptions(Exception ex) {
        return new ResponseEntity<>(new ApiException("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR,null),HttpStatus.BAD_REQUEST);
    }
}
