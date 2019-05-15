package com.xridesbookingdetails.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.xridesbookingdetails.demo.response.Response;


/*This is the controller that handles all the exceptions being thrown during the REST calls*/
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RideNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(RideNotFoundException exception, WebRequest request) {
         Response errorResponse = new Response(new Date(), exception.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExcpetionHandler(Exception exception, WebRequest request) {
        Response errorResponse = new Response(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

