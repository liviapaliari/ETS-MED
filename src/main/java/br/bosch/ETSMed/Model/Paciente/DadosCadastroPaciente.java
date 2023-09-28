package br.bosch.ETSMed.Model.Paciente;

import br.bosch.ETSMed.Model.Endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DadosCadastroPaciente(@NotBlank String nome,
                                    @NotBlank String telefone,
                                    @NotBlank @Email String email,
                                    @NotBlank @Pattern(regexp = "\\d{11}") String cpf,
                                    @NotNull @Valid DadosEndereco endereco) {
}