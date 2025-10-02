package com.example.curse.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.curse.curseException.EvenExcption;

@ControllerAdvice
public class RestExcptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EvenExcption.class)
	private ResponseEntity<String> eventNotFound(EvenExcption x){
		return ResponseEntity.status(HttpStatus.valueOf(0)).body("Erro "+x.getMessage());
	}
	
}
