package br.bosch.ETSMed.Controller;

import br.bosch.ETSMed.Model.Medico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

    // @Autowired que ele entende que precisa inicializar essa classe
    // Através do MedicoRepository que vamos persistir no banco
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dadosCadastroMedico, UriComponentsBuilder uriComponentsBuilder) {
        // Salva no banco um objeto Medico passando como parâmetro o Record com os dados que atribui tudo aos atributos da classe
        var medico = new Medico(dadosCadastroMedico);
        repository.save(medico);

        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size=5, sort = {"nome"}) Pageable pageable) {
        // Colocando o nome exato do campo e a condição, o Spring é inteligente o suficiente para entender que deve buscar somente os registros com campo ativo = true
        // Criar o método no Médico Repository
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable int id) {
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosMedico(medico));
    }


    // @RequestBody indica que vai vir algo pelo corpo da requisição
    // Transaction para indicar que vai mexer no Banco de Dados
    // Valid para ele validar aqueles campos que colocamos @NotNull entre outras Annotations
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dadosAtualizacaoMedico) {
        var medico = repository.getReferenceById(dadosAtualizacaoMedico.id());
        medico.atualizarInformacoes(dadosAtualizacaoMedico);

        return ResponseEntity.ok(new DadosMedico(medico));
    }

    // Indica que vamos ter um parâmetro vindo pela URL, que é o ID
//    @DeleteMapping("/{id}")
//    @Transactional
//    // @PathVariable indica que essa variável é a que vem pela URL
//    public void deletar(@PathVariable int id) {
//        repository.deleteById(id);
//    }

    // O Mapping é referente ao método HTTP, e não à ação que é executada no banco.
    // ResponseEntity serve para retornar um status HTTP
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desativarMedico(@PathVariable int id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }
}