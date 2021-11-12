package com.bridgelabz.employepayrollapp.exception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.employepayrollapp.response.Response;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class EmployeePayrollExceptionHandler {

	 private static final String message = "Exception While Processing REST Request";

	    @ExceptionHandler(HttpMessageNotReadableException.class)
	    public ResponseEntity<Response> handelHttpMessageNotReadableException(
	            HttpMessageNotReadableException exception) {
	        log.error("Invalid Date Format", exception);
	        Response responseDTO = new Response(message, "Should have date in dd MMM yyyy format");
	        return new ResponseEntity<Response>(responseDTO, HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Response> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
	        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
	        List<String> errMesg = errorList.stream()
	                .map(objErr -> objErr.getDefaultMessage())
	                .collect(Collectors.toList());
	        Response responseDTO = new Response(message, errMesg);
	        return new ResponseEntity<Response>(responseDTO, HttpStatus.BAD_REQUEST);
	    }

	    @ExceptionHandler(EmployeePayrollException.class)
	    public ResponseEntity<Response> handleEmployeePayrollException(
	            EmployeePayrollException exception) {
	    	Response responseDTO = new Response(message,
	                exception.getMessage());
	        return new ResponseEntity<Response>(responseDTO, HttpStatus.BAD_REQUEST);
	    }
}
