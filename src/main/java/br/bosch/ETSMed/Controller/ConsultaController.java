package br.bosch.ETSMed.Controller;

import br.bosch.ETSMed.Model.Service.AgendaConsultas;
import br.bosch.ETSMed.Model.Consulta.DadosAgendamentoConsulta;
import br.bosch.ETSMed.Model.Consulta.DadosDetalhamentoConsulta;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private AgendaConsultas agendaConsultas;

    // Transaction deve ser do Spring, não do Jakarta
    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        var detalhamentoConsulta = agendaConsultas.agendar(dadosAgendamentoConsulta);
        return ResponseEntity.ok(detalhamentoConsulta);
    }
}