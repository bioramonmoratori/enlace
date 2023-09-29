package com.enlace.api.component.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.enlace.api.model.Usuario;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.naming.AuthenticationException;

@Service
public class TokenService {
    
    @Value("${api.security.token.secret}")
    private String secret; // Senha da criptografia da aplicacao

    public String generateToken(Usuario usuario){

        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
            .withIssuer("enlaceapi") // Emissor do token
            .withSubject(usuario.getEmail())
            .withExpiresAt(getExpirationDate())
            .sign(algorithm); //Faz a assinatura e a emissao final

            return token;

        } catch (JWTCreationException e){
            throw new RuntimeException("Erro ao gerar token");
        }
    }

    public String validateToken(String token) throws AuthenticationException{

        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                .withIssuer("enlaceapi")
                .build()
                .verify(token)
                .getSubject();

        } catch(JWTVerificationException e){
            //return "";
            throw new AuthenticationException("Token inválido");
        }

    }

    private Instant getExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));

    }

}
