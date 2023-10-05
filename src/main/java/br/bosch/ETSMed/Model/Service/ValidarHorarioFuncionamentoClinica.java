package br.bosch.ETSMed.Model.Service;

import br.bosch.ETSMed.Model.Consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidarHorarioFuncionamentoClinica implements ValidarAgendamentoDeConsultas {
    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        var dataConsulta = dadosAgendamentoConsulta.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDeAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if (domingo || antesDeAberturaDaClinica || depoisDoEncerramentoDaClinica) {
            throw new RuntimeException("Consulta fora do horário de funcionamento da clínica");
        }
    }
}