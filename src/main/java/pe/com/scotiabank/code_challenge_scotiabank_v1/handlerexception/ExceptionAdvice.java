package pe.com.scotiabank.code_challenge_scotiabank_v1.handlerexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(AlumnoExistenteException.class)
    public ResponseEntity<String> alumnoExistente(AlumnoExistenteException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuario existente");
    }

}
