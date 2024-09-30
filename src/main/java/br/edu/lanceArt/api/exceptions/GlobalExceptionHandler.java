package br.edu.lanceArt.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObraDeArteNotFoundException.class)
    public ResponseEntity<String> handleObraDeArteNotFoundException(ObraDeArteNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(InvalidObraDeArteIdException.class)
    public ResponseEntity<String> handleInvalidObraDeArteIdException(InvalidObraDeArteIdException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>("Ocorreu um erro inesperado: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
