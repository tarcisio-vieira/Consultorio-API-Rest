package med.vsgi.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.vsgi.api.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank  // VERIFICA SE NAO É NULO E NAO VAZIO NAO PRECISA @NOTNULL
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        String telefone,

        @NotNull
        @Valid   // outro DTO e preciso que valide tambem
        DadosEndereco endereco

        ) {}
