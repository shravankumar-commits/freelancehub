package com.freelancehub.exception;
import java.util.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
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
}
