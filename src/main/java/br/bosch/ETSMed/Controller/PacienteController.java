package br.bosch.ETSMed.Controller;

import br.bosch.ETSMed.Model.Paciente.DadosCadastroPaciente;
import br.bosch.ETSMed.Model.Paciente.Paciente;
import br.bosch.ETSMed.Model.Paciente.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dadosCadastroPaciente) {
        var paciente = new Paciente(dadosCadastroPaciente);
        pacienteRepository.save(paciente);
    }
}