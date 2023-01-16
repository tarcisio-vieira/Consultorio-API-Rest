package med.vsgi.api.Controller;

import jakarta.validation.Valid;
import med.vsgi.api.paciente.DadosCadastroPaciente;
import med.vsgi.api.paciente.DadosListagemPaciente;
import med.vsgi.api.paciente.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){

        System.out.println(dados);

        repository.save(new Paciente(dados));

    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(Pageable paginacao){

        System.out.println("Paginação: " + paginacao);

        return repository.findAll(paginacao).map(DadosListagemPaciente::new) ;
    }

}
