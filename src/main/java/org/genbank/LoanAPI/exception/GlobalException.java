package org.genbank.LoanAPI.exception;

import java.util.Date;

import javax.management.RuntimeErrorException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {



    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> reponseEntity(UserNotFoundException rteee, WebRequest webRequest){
        return new ResponseEntity<Object>("User Not found", HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(LoanApplicationNotFoundException.class)
    public ResponseEntity<Object> reponseEntity(LoanApplicationNotFoundException rteee, WebRequest webRequest){
        return new ResponseEntity<Object>("Loan Application Not found", HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Object> reponseEntity(AccountNotFoundException rteee, WebRequest webRequest){
        return new ResponseEntity<Object>("Account Not found", HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> reponseEntity(RuntimeErrorException rteee, WebRequest webRequest){
        ErrorClass errorClass = new ErrorClass(rteee.getMessage(),new Date(),webRequest.getDescription(false));
        return new ResponseEntity<Object>(errorClass, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
