package br.bosch.ETSMed.Model.Medico;

import br.bosch.ETSMed.Model.Endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

// Passar somente os parâmetros que vão ser possíveis atualizar
public record DadosAtualizacaoMedico(@NotNull int id,
                                     String nome,
                                     String telefone,
                                     DadosEndereco endereco) {
}