package com.mhomecare.customer.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mhomecare.customer.responsetype.SingleResponseObject;
 
@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler 
{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Server Error", details);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    
    @ExceptionHandler(DataNotFoundException.class)
    public final ResponseEntity<SingleResponseObject<Object>> handleDataNotFoundException(DataNotFoundException ex,
    		WebRequest request) {
    	List<String> details = new ArrayList<>();
    	details.add(ex.getLocalizedMessage());
    	ErrorResponse error = new ErrorResponse(ErrorMessage.DATA_NOT_FOUND, details);
    	SingleResponseObject<Object> respObj = new SingleResponseObject<Object>(error);
    	return new ResponseEntity<SingleResponseObject<Object>>(respObj, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(InvalidInputException.class)
    public final ResponseEntity<SingleResponseObject<Object>> handleInvalidInputException(InvalidInputException ex,
    		WebRequest request) {
    	List<String> details = new ArrayList<>();
    	details.add(ex.getLocalizedMessage());
    	ErrorResponse error = new ErrorResponse(ErrorMessage.INPUT_MISSING, details);
    	SingleResponseObject<Object> respObj = new SingleResponseObject<Object>(error);
    	return new ResponseEntity<SingleResponseObject<Object>>(respObj, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(AuthorizationException.class)
    public final ResponseEntity<SingleResponseObject<Object>> handleAuthorizationException(AuthorizationException ex,
    		WebRequest request) {
    	List<String> details = new ArrayList<>();
    	details.add(ex.getLocalizedMessage());
    	ErrorResponse error = new ErrorResponse(ErrorMessage.AUTHORIZATION_FAILED, details);
    	SingleResponseObject<Object> respObj = new SingleResponseObject<Object>(error);
    	return new ResponseEntity<SingleResponseObject<Object>>(respObj, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(DuplicateException.class)
    public final ResponseEntity<SingleResponseObject<Object>> handleDulicateException(DuplicateException ex,
    		WebRequest request) {
    	List<String> details = new ArrayList<>();
    	details.add(ex.getLocalizedMessage());
    	ErrorResponse error = new ErrorResponse(ErrorMessage.DUPLICATE_RECORD, details);
    	SingleResponseObject<Object> respObj = new SingleResponseObject<Object>(error);
    	return new ResponseEntity<SingleResponseObject<Object>>(respObj, HttpStatus.BAD_REQUEST);
    }
}