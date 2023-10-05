package br.bosch.ETSMed.Model.Service;

import br.bosch.ETSMed.Model.Consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidarAgendamentoDeConsultas {
    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        var dataConsulta = dadosAgendamentoConsulta.data();
        var agora = LocalDateTime.now();
        // Cuidado com esse método, ele não retorna valor absoluto
        // Ou seja, ele retora números positivos e negativos
        // Depende da ordem que você passar as variáveis
        var diferencaMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaMinutos < 30) {
            throw new RuntimeException("Consulta deve ser agendada com antecedência de no mínimo 30 minutos");
        }
    }
}