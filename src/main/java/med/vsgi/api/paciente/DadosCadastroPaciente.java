package med.vsgi.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.vsgi.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotNull
        String telefone,

        @NotNull
        @Valid
        DadosEndereco endereco

) {}
