package br.bosch.ETSMed.Model.Service;

import br.bosch.ETSMed.Model.Consulta.DadosAgendamentoConsulta;

public interface ValidarAgendamentoDeConsultas {
    // Aqui na interface vamos carregar todos os métodos que criamos
    // Para validar a data da consulta (todos devem chamar validar)
    // E aqui na interface vamos chamar todos de uma vez
    // Implementa essa interface no método, e coloca a Annotation @Component em cima da classe da validação
    void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta);
}