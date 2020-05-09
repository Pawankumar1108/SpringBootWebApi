package com.anz.wholesale.customException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IncorrectPasswordException.class)
	public final ResponseEntity<Object>handleAllExceptions(IncorrectPasswordException incorrectPasswordException){
		
		EmployeeCustomExceptionSchema employeePasswordResponse =
				  new EmployeeCustomExceptionSchema(
						  incorrectPasswordException.getMessage(),
						  incorrectPasswordException.getDetails(),
						  incorrectPasswordException.getHint(),
						  incorrectPasswordException.getNextActions(),
						  incorrectPasswordException.getSupport());
		return ResponseEntity(employeePasswordResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	  private ResponseEntity<Object> ResponseEntity(EmployeeCustomExceptionSchema
	  employeePasswordResponse, HttpStatus internalServerError) {
	  
	  return null; }
	 
	
}
