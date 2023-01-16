package med.vsgi.api.Controller;

import jakarta.validation.Valid;
import med.vsgi.api.paciente.DadosAtualizacaoPaciente;
import med.vsgi.api.paciente.DadosCadastroPaciente;
import med.vsgi.api.paciente.DadosListagemPaciente;
import med.vsgi.api.paciente.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){

        System.out.println(dados);

        repository.save(new Paciente(dados));

    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){

      //  System.out.println("Paginação: " + paginacao);

        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new) ;
    }

    @PutMapping
    @Transactional //precisa de uma transação
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados){  //outro DTO com menos campos

        // System.out.println("ID solicitado: " + dados.id());

        Paciente paciente = repository.getReferenceById(dados.id());

        paciente.atualizarInformacoes(dados);

    }











    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){  //outro DTO com menos campos

        // Não apaga o registro mas inativa sua visualização , conceito de exclusão. devido a chaves estrangeiras e fica o historico

        //Pega esse complemento /{id} com @PathVariable

        // exclusao fisica usar repository.deleteById(id);

        //Exclusão logica usar

        repository.deleteById(id);

        System.out.println("Exclusão realizada com sucesso!");

    }

}