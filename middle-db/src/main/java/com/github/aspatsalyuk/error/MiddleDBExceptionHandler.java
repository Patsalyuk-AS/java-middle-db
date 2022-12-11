package com.github.aspatsalyuk.error;

import com.github.aspatsalyuk.exception.MiddleDBException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

import static com.github.aspatsalyuk.dictionary.ErrorDescription.TRACK_NOT_FOUND;

@ControllerAdvice
@Slf4j
public class MiddleDBExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object>  handleEntityNotFoundException(EntityNotFoundException exception) {
        log.info("EntityNotFoundException: {}", exception.getMessage());
        return ResponseEntity.status(TRACK_NOT_FOUND.getStatusCode())
                .body(
                        ErrorDTO.builder()
                                .errorCode(TRACK_NOT_FOUND.getErrorCode())
                                .errorDescription(TRACK_NOT_FOUND.getDescription())
                                .build()
                );
    }

    @ExceptionHandler(MiddleDBException.class)
    protected ResponseEntity<Object>  handleMiddleDBException(MiddleDBException exception) {
        log.info("MiddleDBException: {}", exception.getErrorDescription());
        return ResponseEntity.status(exception.getStatusCode())
                .body(
                        ErrorDTO.builder()
                                .errorCode(exception.getErrorCode())
                                .errorDescription(exception.getErrorDescription())
                                .build()
                );
    }
}
