package br.bosch.ETSMed.Model.Consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(int id,
                                        int idMedico,
                                        int idPaciente,
                                        LocalDateTime data) {
}