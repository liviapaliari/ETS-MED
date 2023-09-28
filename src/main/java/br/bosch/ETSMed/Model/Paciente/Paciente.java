package br.bosch.ETSMed.Model.Paciente;

import br.bosch.ETSMed.Model.Endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Table(name = "Pacientes")
@Entity(name = "Paciente")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
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

    public void atualizarInformacoes(DadosAtualizacaoPaciente dadosAtualizacaoPaciente) {
        if (dadosAtualizacaoPaciente.nome() != null) {
            this.nome = dadosAtualizacaoPaciente.nome();
        }

        if (dadosAtualizacaoPaciente.telefone() != null) {
            this.telefone = dadosAtualizacaoPaciente.telefone();
        }

        if (dadosAtualizacaoPaciente.endereco() != null) {
            this.endereco.atualizarInformacoes(dadosAtualizacaoPaciente.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }

    public int getId() {
        return id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}