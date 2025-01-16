package pe.com.scotiabank.code_challenge_scotiabank_v1.controller.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoRequest {

    @NotNull
    private Long id;

    @Size(min = 1, max = 50)
    private String nombre;

    @Size(min = 1, max = 50)
    private String apellido;

    @NotNull
    private Integer edad;

    @Size(min = 6, max = 8)
    @Pattern(regexp = "ACTIVO|INACTIVO")
    private String estado;

}
