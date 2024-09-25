package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class BaseController extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler({ NoRecordFoundException.class })
	public ResponseEntity<ErrorMessage> handleNoRecordFoundException(NoRecordFoundException exception) {

		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

		return new ResponseEntity<ErrorMessage>(errorMessage, errorMessage.getStatus());
	}

	
	@ExceptionHandler({ PasswordMismatchException.class })
	public ResponseEntity<ErrorMessage> passwordMismatchException(PasswordMismatchException exception) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		return new ResponseEntity<ErrorMessage>(message, message.getStatus());

	}
	@ExceptionHandler({ UserNotFound.class })
	public ResponseEntity<ErrorMessage> handleUserNotFoundException(UserNotFound exception) {
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		return new ResponseEntity<>(errorMessage, errorMessage.getStatus());

	}


	
	@ExceptionHandler({ EmailChecking.class })
	public ResponseEntity<ErrorMessage> EmailCheckingException(EmailChecking exception) {
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		return new ResponseEntity<>(errorMessage, errorMessage.getStatus());

	}
	
	@ExceptionHandler({ PhonenumberCheck.class })
	public ResponseEntity<ErrorMessage> Phonenumbercheck(PhonenumberCheck exception) {
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		return new ResponseEntity<>(errorMessage, errorMessage.getStatus());

	}
	
	
}


