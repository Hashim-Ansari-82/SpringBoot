package in.employee.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorPage> exceptionHandler(ResourceNotFoundException ex, HttpServletRequest req) {

        ErrorPage errorResp = new ErrorPage(HttpStatus.NOT_FOUND.value(), LocalDateTime.now(), ex.getMessage(),
                HttpStatus.NOT_FOUND.getReasonPhrase(), req.getRequestURI());

        return new ResponseEntity<>(errorResp, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorPage> exceptionDuplicateHandler(DuplicateResourceException ex, HttpServletRequest req) {

        ErrorPage errorResp = new ErrorPage(HttpStatus.CONFLICT.value(), LocalDateTime.now(), ex.getMessage(),
                HttpStatus.CONFLICT.getReasonPhrase(), req.getRequestURI());

        return new ResponseEntity<>(errorResp, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionRespDto> handleValidation(
            MethodArgumentNotValidException ex,
            HttpServletRequest req) {

        Map<String, String> fieldErrors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        fieldErrors.put(error.getField(), error.getDefaultMessage()));

        ValidationExceptionRespDto errorResp = new ValidationExceptionRespDto(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Validation Failed",
                req.getRequestURI(),
                fieldErrors
        );

        return ResponseEntity
                .badRequest()
                .body(errorResp);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());

    }
}
