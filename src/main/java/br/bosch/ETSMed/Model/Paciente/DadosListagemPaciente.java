package br.bosch.ETSMed.Model.Paciente;

public record DadosListagemPaciente(int id,
                                    String nome,
                                    String email,
                                    String cpf) {

    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getCpf());
    }
}