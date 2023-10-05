package br.bosch.ETSMed.Model.Consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(int id,
                                        int idMedico,
                                        int idPaciente,
                                        LocalDateTime data) {

    public DadosDetalhamentoConsulta(Consulta consulta) {
        this(
                consulta.getId(),
                consulta.getMedico().getId(),
                consulta.getPaciente().getId(),
                consulta.getData()
        );
    }
}