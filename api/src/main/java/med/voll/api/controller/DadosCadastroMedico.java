package med.voll.api.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.Especialidade;

public record DadosCadastroMedico(
        @NotBlank
        String nome,

        @NotBlank
        String telefone,

        @NotBlank
                @Email
        String email,
        @NotBlank
                @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
                @Valid
        DadosEndereco endereco) {
}
