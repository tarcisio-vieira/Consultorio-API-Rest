package med.vsgi.api.Controller;

import med.vsgi.api.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
