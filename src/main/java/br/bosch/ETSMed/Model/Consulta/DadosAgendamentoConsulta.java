package br.bosch.ETSMed.Model.Consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(int idMedico,
                                       @NotNull int idPaciente,
                                       @NotNull @Future LocalDateTime data) {
}