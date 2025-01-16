package pe.com.scotiabank.code_challenge_scotiabank_v1.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.scotiabank.code_challenge_scotiabank_v1.controller.model.AlumnoRequest;
import pe.com.scotiabank.code_challenge_scotiabank_v1.handlerexception.AlumnoExistenteException;
import pe.com.scotiabank.code_challenge_scotiabank_v1.repository.AlumnoRepository;
import pe.com.scotiabank.code_challenge_scotiabank_v1.repository.entity.AlumnoEntity;
import pe.com.scotiabank.code_challenge_scotiabank_v1.service.AlumnoService;
import pe.com.scotiabank.code_challenge_scotiabank_v1.controller.model.AlumnoResponse;
import pe.com.scotiabank.code_challenge_scotiabank_v1.util.EstadoCatalog;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public record AlumnoServiceImpl(AlumnoRepository repository) implements AlumnoService {

    @Override
    public Flux<ResponseEntity<AlumnoResponse>> alumnos() {
        return Mono.fromCallable(repository::findAll)
                .flatMapIterable(alumnoEntities -> alumnoEntities)
                .map(this::mapResponse)
                .map(ResponseEntity::ok);
    }

    private AlumnoResponse mapResponse(AlumnoEntity entity) {
        return AlumnoResponse.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .edad(entity.getEdad())
                .estado(entity.getEstado())
                .build();
    }

    private Mono<Boolean> validarAlumno(Long id) {
        return Mono.fromCallable(() -> repository.existsById(id))
                .map(existsId -> {
                    if (existsId) {
                        throw new AlumnoExistenteException();
                    }
                    return null;
                });
    }

    private Mono<AlumnoResponse> guardarAlumno(AlumnoRequest request) {
        return Mono.fromCallable(() -> AlumnoEntity.builder()
                .id(request.getId())
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .edad(request.getEdad())
                .estado(EstadoCatalog.valueOf(request.getEstado()))
                .build())
                .map(repository::save)
                .map(this::mapResponse);
    }


    @Override
    public Mono<ResponseEntity<AlumnoResponse>> guardar(AlumnoRequest request) {
        return validarAlumno(request.getId())
                .flatMap(o -> Mono.defer(() -> guardarAlumno(request)))
                .map(alumnoResponse -> ResponseEntity.noContent().build());
    }

}
