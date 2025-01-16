package pe.com.scotiabank.code_challenge_scotiabank_v1.repository.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import pe.com.scotiabank.code_challenge_scotiabank_v1.util.EstadoCatalog;

@Entity
@Table(name = "AlumnoResponse")

@Data
@Builder
public class AlumnoEntity {

    @Id
    private Long id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String apellido;

    @Column(nullable = false)
    private Integer edad;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoCatalog estado;

}
