package formularioPersonaBackend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PersonaNotFoundException.class)
    public ResponseEntity<?> handleNotFound(PersonaNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(DuplicateIdentificationException.class)
    public ResponseEntity<?> handleDuplicate(DuplicateIdentificationException e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
