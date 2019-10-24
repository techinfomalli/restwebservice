package com.malli.rest.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.malli.rest.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomisedResponseEntitiyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex,WebRequest request){
		
		ExceptionResponse exceptioinResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity(exceptioinResponse,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleAllUserException(Exception ex,WebRequest request){
		
		ExceptionResponse exceptioinResponse = new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(true));
		return new ResponseEntity(exceptioinResponse,HttpStatus.NOT_FOUND);
		
		
	}
	
}
