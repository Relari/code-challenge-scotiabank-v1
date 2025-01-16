package pe.com.scotiabank.code_challenge_scotiabank_v1.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.scotiabank.code_challenge_scotiabank_v1.controller.model.AlumnoRequest;
import pe.com.scotiabank.code_challenge_scotiabank_v1.controller.model.AlumnoResponse;
import pe.com.scotiabank.code_challenge_scotiabank_v1.service.AlumnoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "${application.api.path}/alumnos")
public record AlumnoController(AlumnoService service) {


//    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping
    public Flux<ResponseEntity<AlumnoResponse>> alumnos() {
        return service.alumnos();
    }

    @PostMapping
    public Mono<ResponseEntity<AlumnoResponse>> save(@RequestBody AlumnoRequest request) {
        return service.guardar(request);
    }

}
