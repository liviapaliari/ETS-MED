package br.bosch.ETSMed.Model.Paciente;

import br.bosch.ETSMed.Model.Endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(@NotNull int id,
                                       String nome,
                                       String telefone,
                                       DadosEndereco endereco) {
}