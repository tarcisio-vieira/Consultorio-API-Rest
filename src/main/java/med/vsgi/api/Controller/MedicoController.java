package med.vsgi.api.Controller;

import jakarta.validation.Valid;
import med.vsgi.api.medico.DadosAtualizacaoMedico;
import med.vsgi.api.medico.DadosCadastroMedico;
import med.vsgi.api.medico.DadosListagemMedico;
import med.vsgi.api.medico.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){

        System.out.println(dados);

        repository.save(new Medico(dados));

    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 2, sort = {"nome"}) Pageable paginacao){

       //  return repository.findAll(paginacao).stream().map(DadosListagemMedico::new).toList()  ;

       // System.out.println("Lista solicitada: " + paginacao);

        return repository.findAll(paginacao).map(DadosListagemMedico::new) ;

    }

    @PutMapping
    @Transactional //precisa de uma transação
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){  //outro DTO com menos campos

        // System.out.println("ID solicitado: " + dados.id());

        Medico medico = repository.getReferenceById(dados.id());

        medico.atualizarInformacoes(dados);

    }


















    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){  //outro DTO com menos campos

        // Não apaga o registro mas inativa sua visualização , conceito de exclusão. devido a chaves estrangeiras e fica o historico

        //Pega esse complemento /{id} com @PathVariable

       // exclusao fisica usar repository.deleteById(id);

        //Exclusão logica usar



        System.out.println("Exclusão realizada com sucesso!");

    }



















    }
