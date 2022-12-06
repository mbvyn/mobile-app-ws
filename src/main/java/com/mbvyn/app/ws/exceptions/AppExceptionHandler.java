package com.mbvyn.app.ws.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mbvyn.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {

		String errorMessageDesctiption = ex.getLocalizedMessage();

		if (errorMessageDesctiption == null)
			errorMessageDesctiption = ex.toString();

		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDesctiption);

		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { NullPointerException.class, UserServiceEcxeption.class })
	public ResponseEntity<Object> handleSpecificExceptions(Exception ex, WebRequest request) {

		String errorMessageDesctiption = ex.getLocalizedMessage();

		if (errorMessageDesctiption == null)
			errorMessageDesctiption = ex.toString();

		ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDesctiption);

		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
