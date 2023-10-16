package br.bosch.ETSMed.Controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class ConsultaControllerTest {
    // MockMVC simula a requisição, nao é neces´sario usar o Insomnia
    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Deveria devolver código HTTP 400 quando informações estão inválidas")
    // serve para tirar aquelas obrigações de validar tudo, porque ele identifica que é um teste
    @WithMockUser
    void agendar() throws Exception {
        var response = mvc.perform(post("/consultas")).andReturn().getResponse();
        // importar assertThat do Assertions
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}