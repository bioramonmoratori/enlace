package com.enlace.insta.apiinsta.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class AutenticacaoService {
    
    @Autowired
    private RestTemplate restTemplate;

    public String autenticacao(String url, String username, String password){
        
        // Configurar os parâmetros no formato x-www-form-urlencoded
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", username);
        params.add("password", password);

        // Configurar os cabeçalhos da requisição
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // Criar a entidade de requisição com os parâmetros e cabeçalhos
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        // Enviar a requisição POST
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        
        String sessionID = responseEntity.getBody().replace("\"", "");

        return sessionID;
    }

    public String obterIDDoUsuario(String url, String username, String sessionID){
        
        // Configurar os parâmetros no formato x-www-form-urlencoded
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", username);
        params.add("sessionid", sessionID);

        // Configurar os cabeçalhos da requisição
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // Criar a entidade de requisição com os parâmetros e cabeçalhos
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        // Enviar a requisição POST
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        
        String userID = responseEntity.getBody().replace("\"", "");
        
        return userID;
    }

}
