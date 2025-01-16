package pe.com.scotiabank.code_challenge_scotiabank_v1.service;

import org.springframework.http.ResponseEntity;
import pe.com.scotiabank.code_challenge_scotiabank_v1.controller.model.AlumnoRequest;
import pe.com.scotiabank.code_challenge_scotiabank_v1.controller.model.AlumnoResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AlumnoService {

    Flux<ResponseEntity<AlumnoResponse>> alumnos();
    Mono<ResponseEntity<AlumnoResponse>> guardar(AlumnoRequest request);

}
