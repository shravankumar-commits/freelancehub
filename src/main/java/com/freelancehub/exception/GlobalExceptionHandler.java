package com.freelancehub.exception;
import java.util.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String>handleValidationException(MethodArgumentNotValidException ex)
	{
		Map<String, String>errors=new LinkedHashMap<>();
		ex.getBindingResult()
		  .getFieldErrors()
		  .forEach(error -> {
	          if (!errors.containsKey(error.getField())) {
	              errors.put(
	                  error.getField(),
	                  error.getDefaultMessage()
	              );
	          }
	      });

	    return errors;
	}
	@ExceptionHandler(RuntimeException.class)
	//@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {

	    Map<String, String> error = new LinkedHashMap<>();
	    error.put("message", ex.getMessage());

	    return ResponseEntity.badRequest().body(error);
	}
}
