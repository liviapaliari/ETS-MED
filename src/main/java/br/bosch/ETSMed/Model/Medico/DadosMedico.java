package br.bosch.ETSMed.Model.Medico;

import br.bosch.ETSMed.Model.Endereco.Endereco;

public record DadosMedico(
        int id,
        String nome,
        String email,
        String crm,
        String telefone,
        boolean ativo,
        Especialidade especialidade,
        Endereco endereco
) {
    public DadosMedico(Medico medico) {
        this(medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getTelefone(),
                medico.isAtivo(),
                medico.getEspecialidade(),
                medico.getEndereco());
    }
}