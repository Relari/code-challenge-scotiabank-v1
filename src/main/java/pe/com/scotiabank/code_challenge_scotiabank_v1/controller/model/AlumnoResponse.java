package pe.com.scotiabank.code_challenge_scotiabank_v1.controller.model;

import lombok.Builder;
import lombok.Getter;
import pe.com.scotiabank.code_challenge_scotiabank_v1.util.EstadoCatalog;

@Getter
@Builder
public class AlumnoResponse {

    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private EstadoCatalog estado;

}
