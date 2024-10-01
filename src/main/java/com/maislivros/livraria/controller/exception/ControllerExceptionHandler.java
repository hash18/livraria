package com.maislivros.livraria.controller.exception;

import com.maislivros.livraria.service.EntityNotFound.EntityNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 *
 * @author Rangel
 */
@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<ErrorResponse> notFound(EntityNotFound e, HttpServletRequest request) {
        String error = "Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;

        // Instância de ErrorResponse sem a necessidade de @Autowired
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(Instant.now());
        errorResponse.setStatus(status.value());
        errorResponse.setError(error);
        errorResponse.setMessage(e.getMessage());
        errorResponse.setPath(request.getRequestURI());

        // Retorna o ResponseEntity com o objeto de erro preenchido
        return ResponseEntity.status(status).body(errorResponse);
    }
}
