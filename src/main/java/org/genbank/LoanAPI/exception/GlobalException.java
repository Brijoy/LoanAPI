package org.genbank.LoanAPI.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {



    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorClass> reponseEntity(UserNotFoundException rteee, WebRequest webRequest){

        ErrorClass errorObj = new ErrorClass(
                rteee.getMessage(),
                LocalDateTime.now(),
                webRequest.getDescription(true),
                "User Not found"
        );

        return new ResponseEntity<>(errorObj, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(LoanApplicationNotFoundException.class)
    public ResponseEntity<ErrorClass> reponseEntity(LoanApplicationNotFoundException rteee, WebRequest webRequest){
        //return new ResponseEntity<Object>("Loan Application Not found", HttpStatus.NOT_FOUND);
        ErrorClass errorObj = new ErrorClass(
                rteee.getMessage(),
                LocalDateTime.now(),
                webRequest.getDescription(true),
                "Loan Application Not found"
        );

        return new ResponseEntity<>(errorObj, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Object> reponseEntity(AccountNotFoundException rteee, WebRequest webRequest){
        return new ResponseEntity<Object>("Account Not found", HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> reponseEntity(RuntimeErrorException rteee, WebRequest webRequest){
        ErrorClass errorClass = new ErrorClass(rteee.getMessage(),LocalDateTime.now(),webRequest.getDescription(false),"INTERNAL SERVER ERROR");
        return new ResponseEntity<Object>(errorClass, HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();

        errorList.forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName,message);
        });

        return new ResponseEntity<>( errors, HttpStatus.BAD_REQUEST);
    }
}
