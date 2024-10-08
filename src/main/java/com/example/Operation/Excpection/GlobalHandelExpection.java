package com.example.Operation.Excpection;

import com.example.Operation.Payload.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalHandelExpection {
    @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<ErrorDto>handelExcpection(ResourceNotFoundException r , WebRequest webRequest){

        ErrorDto errorDto = new ErrorDto(r.getMessage() , new Date() , webRequest.getDescription(true));
        return ResponseEntity.ok(errorDto);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> globalhandel(Exception e){
        return new ResponseEntity<>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
    }
}