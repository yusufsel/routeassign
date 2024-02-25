package com.ysf.routeassign.exception;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ValidationException extends ApiException{

    public ValidationException(Map<String, String> detail) {
        super("Validation failed", HttpStatus.BAD_REQUEST, detail);
    }
}
