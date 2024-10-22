package com.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.ems.pojo.ErrorResponse;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex, WebRequest wr) {
		ErrorResponse response = new ErrorResponse();
		response.setCode(404);
		response.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.NOT_FOUND);
	}

}
