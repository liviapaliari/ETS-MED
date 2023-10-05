package br.bosch.ETSMed.Model.Service;

import br.bosch.ETSMed.Model.Consulta.Consulta;
import br.bosch.ETSMed.Model.Consulta.ConsultaRepository;
import br.bosch.ETSMed.Model.Consulta.DadosAgendamentoConsulta;
import br.bosch.ETSMed.Model.Consulta.DadosDetalhamentoConsulta;
import br.bosch.ETSMed.Model.Medico.Medico;
import br.bosch.ETSMed.Model.Medico.MedicoRepository;
import br.bosch.ETSMed.Model.Paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaConsultas {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    // Vamos chamar todos os validadores
    @Autowired
    private List<ValidarAgendamentoDeConsultas> validadores;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        if (!pacienteRepository.existsById(dadosAgendamentoConsulta.idPaciente())) {
            throw new RuntimeException("ID do Paciente não existe");
        }
        if (dadosAgendamentoConsulta.idMedico() != 0 && !medicoRepository.existsById(dadosAgendamentoConsulta.idMedico())) {
            throw new RuntimeException("ID do Médico não existe");
        }

        // Onde vou chamar cada validação para a consulta
        validadores.forEach(v-> v.validar(dadosAgendamentoConsulta));

        var paciente = pacienteRepository.findById(dadosAgendamentoConsulta.idPaciente()).get();
        var medico = escolherMedico(dadosAgendamentoConsulta);
        var consulta = new Consulta(0, medico, paciente, dadosAgendamentoConsulta.data());
        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        if (dadosAgendamentoConsulta.idMedico() != 0) {
            return medicoRepository.getReferenceById(dadosAgendamentoConsulta.idMedico());
        }
        if (dadosAgendamentoConsulta.especialidade() == null) {
            throw new RuntimeException("Especialidade é obrigatória quando não seleciona médico");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dadosAgendamentoConsulta.especialidade(), dadosAgendamentoConsulta.data());
    }

    // ReferenceById -> retorna um objeto imutável
    // FindById -> retorna um novo objeto
}