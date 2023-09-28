package br.bosch.ETSMed.Infra.Exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorErros {

    // Por padrão quando gera exceção no código, o código retornado é o 500 (internal server error)
    // Indicando para o Spring, que quando uma exceção do tipo não encontrada for lançada, não retorne o erro 500 (erro interno no servidor) e sim o erro 404 (not found)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException e) {
        var error = e.getFieldError();

        // Retornando não somente o erro mas uma mensagem também
        return ResponseEntity.badRequest().body(error);
    }
}