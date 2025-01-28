package br.com.unifap.mentorr.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> resourceNotFoundException(final ResourceNotFoundException ex) {
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<String> insufficientAuthenticationException(final AuthenticationException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ESSSSSSSSSSSSSSA");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidExceptionHandle(final MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();

        Map<String, Object> fields = bindingResult.getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage
                ));

        ErrorResponse errorResponse = ErrorResponse.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .error("invalid fields")
                .fields(fields)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handleBadCredentialsException(BadCredentialsException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password!");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error!");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, Object>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        Map<String, Object> response = new HashMap<>();

        Throwable rootCause = ex.getRootCause();
        String rootCauseMessage = rootCause != null ? rootCause.getMessage() : ex.getMessage();

        response.put("error", "Data Integrity Violation");
        response.put("message", rootCauseMessage);

        if (rootCauseMessage != null && rootCauseMessage.contains("constraint")) {
            response.put("details", extractConstraintDetails(rootCauseMessage));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    private Map<String, Object> extractConstraintDetails(String message) {
        Map<String, Object> details = new HashMap<>();

        if (message.contains("UNIQUE")) {
            details.put("type", "Unique constraint violation");
            details.put("field", extractFieldFromMessage(message, "UNIQUE"));
        } else if (message.contains("NOT NULL")) {
            details.put("type", "Not null constraint violation");
            details.put("field", extractFieldFromMessage(message, "NOT NULL"));
        }

        return details;
    }

    private String extractFieldFromMessage(String message, String type) {
        int startIndex = message.indexOf("[") + 1;
        int endIndex = message.indexOf("]");
        if (startIndex > 0 && endIndex > startIndex) {
            return message.substring(startIndex, endIndex);
        }

        return "unknown";
    }

}
