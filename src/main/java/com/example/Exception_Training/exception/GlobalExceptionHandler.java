package com.example.Exception_Training.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = NoSuchCricketerException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorResponse handleException(NoSuchCricketerException ex) {
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	}
	@ExceptionHandler(value = CricketerAlreadyExist.class)
	public ResponseEntity<ErrorResponse> handleCricketerAlreadyExist(CricketerAlreadyExist ex)
	{
		ErrorResponse err=new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage())	;
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
}
