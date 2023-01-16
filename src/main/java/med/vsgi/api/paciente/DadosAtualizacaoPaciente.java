package med.vsgi.api.paciente;

import jakarta.validation.constraints.NotNull;
import med.vsgi.api.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco

        ) {}
