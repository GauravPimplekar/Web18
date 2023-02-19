package com.StudentReport.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobleExceptionHandler {

	
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<String> getStudentException(StudentException getException){
		// this is self created exception
		return new ResponseEntity<>(getException.getMessage(), HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> getValidationException(MethodArgumentNotValidException getValidationException){
		// this is exception execute when validation exception happen
		return new ResponseEntity<>(getValidationException.getMessage(), HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> getStudentException(Exception exception){
		// this is common exception if any exception not handle by upper exception
		// then this exception use
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
