package pe.com.scotiabank.code_challenge_scotiabank_v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.scotiabank.code_challenge_scotiabank_v1.repository.entity.AlumnoEntity;

@Repository
public interface AlumnoRepository extends JpaRepository<AlumnoEntity, Long> {

}
