package br.bosch.ETSMed.Model.Endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private String logradouro, bairro, cep, cidade, uf, numero, complemento;

    public Endereco(DadosEndereco dadosEndereco) {
        // Atribuindo os valores do Record para o Objeto
        this.logradouro = dadosEndereco.logradouro();
        this.bairro = dadosEndereco.bairro();
        this.cep = dadosEndereco.cep();
        this.cidade = dadosEndereco.cidade();
        this.uf = dadosEndereco.uf();
        this.numero = dadosEndereco.numero();
        this.complemento = dadosEndereco.complemento();
    }

    public void atualizarInformacoes(DadosEndereco dadosEndereco) {
        this.logradouro = dadosEndereco.logradouro() != null ? dadosEndereco.logradouro() : this.logradouro;
        this.bairro = dadosEndereco.bairro() != null ? dadosEndereco.bairro() : this.bairro;
        this.cep = dadosEndereco.cep() != null ? dadosEndereco.cep() : this.cep;
        this.cidade = dadosEndereco.cidade() != null ? dadosEndereco.cidade() : this.cidade;
        this.uf = dadosEndereco.uf() != null ? dadosEndereco.uf() : this.uf;
        this.numero = dadosEndereco.numero() != null ? dadosEndereco.numero() : this.numero;
        this.complemento = dadosEndereco.complemento() != null ? dadosEndereco.complemento() : this.complemento;
    }
}