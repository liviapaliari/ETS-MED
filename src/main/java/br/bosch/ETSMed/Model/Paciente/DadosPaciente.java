package br.bosch.ETSMed.Model.Paciente;

import br.bosch.ETSMed.Model.Endereco.Endereco;

public record DadosPaciente(int id,
                            boolean ativo,
                            String nome,
                            String telefone,
                            String email,
                            String cpf,
                            Endereco endereco
                            ) {

    public DadosPaciente(Paciente paciente) {
        this(paciente.getId(),
                paciente.isAtivo(),
                paciente.getNome(),
                paciente.getTelefone(),
                paciente.getEmail(),
                paciente.getCpf(),
                paciente.getEndereco());
    }
}