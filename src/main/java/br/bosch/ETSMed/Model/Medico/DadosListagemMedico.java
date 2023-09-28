package br.bosch.ETSMed.Model.Medico;

// Record para transformar de Entidade para Record
public record DadosListagemMedico(int id,
                                  String nome,
                                  String email,
                                  String crm,
                                  Especialidade especialidade) {

    public DadosListagemMedico (Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}