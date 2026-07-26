package com.centrelead.Centre_Lead_Project.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.centrelead.Centre_Lead_Project.responses.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {

	    ErrorResponse error = new ErrorResponse(
	            ex.getMessage(),
	            HttpStatus.BAD_REQUEST.value(),
	            LocalDateTime.now()
	    );

	    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {

	    String message = ex.getBindingResult()
	            .getFieldErrors()
	            .stream()
	            .map(error -> error.getField() + ": " + error.getDefaultMessage())
	            .findFirst()
	            .orElse("Validation failed");

	    ErrorResponse error = new ErrorResponse(
	            message,
	            HttpStatus.BAD_REQUEST.value(),
	            LocalDateTime.now()
	    );

	    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
