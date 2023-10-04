package br.bosch.ETSMed.Infra.Security;

import br.bosch.ETSMed.Model.Usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    // CHAVE DE SEGURANÇA DA API
    @Value("{api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario) {
        try {
            // SENHA DA API, O IDEAL NÃO É DEIXAR NO CÓDIGO E SIM EM UMA VARIÁVEL DE AMBIENTE
            var algoritimo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withSubject(usuario.getLogin())
                    .withIssuer("API")
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritimo);
        }
        catch (JWTCreationException exception) {
            throw new RuntimeException();
        }
    }

    private Instant dataExpiracao() {
        // VAI COLOCAR DUAS HORAS PRA FRENTE NO HORÁRIO DE BRASÍLIA, PORQUE O TOKEN VAI TER 2H DE VALIDADE
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String getSubject(String tokenJWT) {
        try {
            var algoritimo = Algorithm.HMAC256(secret);
            return JWT.require(algoritimo)
                    .withIssuer("API")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        }
        catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido");
        }
    }
}