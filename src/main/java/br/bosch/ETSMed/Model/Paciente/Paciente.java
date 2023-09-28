package br.bosch.ETSMed.Model.Paciente;

import br.bosch.ETSMed.Model.Endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "Pacientes")
@Entity(name = "Paciente")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean ativo;
    private String nome, telefone, email, cpf;
    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dadosCadastroPaciente) {
        this.ativo = true;
        this.nome = dadosCadastroPaciente.nome();
        this.telefone = dadosCadastroPaciente.telefone();
        this.email = dadosCadastroPaciente.email();
        this.cpf = dadosCadastroPaciente.cpf();
        this.endereco = new Endereco(dadosCadastroPaciente.endereco());
    }
}