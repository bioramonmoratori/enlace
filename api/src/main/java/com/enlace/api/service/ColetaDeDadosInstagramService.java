package com.enlace.api.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.enlace.api.component.dto.ColetaDeDadosInstagram.ContatoForm;


@Service
public class ColetaDeDadosInstagramService {
    
    @Autowired
    RestTemplate restTemplate;

    //Serve para obter seguidores e seguindo
    public List<ContatoForm> obterTodosOsSeguidores(String url, String sessionID, String userID){

        // Configurar os parâmetros como um objeto JSON
        Map<String, Object> params = new HashMap<>();
        params.put("sessionID", sessionID);
        params.put("userID", userID);

        // Configurar os cabeçalhos da requisição
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // Criar a entidade de requisição com os parâmetros e cabeçalhos
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(params, headers);

        // Enviar a requisição POST
        ResponseEntity<List<ContatoForm>> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, new ParameterizedTypeReference<List<ContatoForm>>() {});

        // A resposta JSON é automaticamente convertida para uma lista de ContatoForm
        List<ContatoForm> listaDeUsuarios = responseEntity.getBody();

        return listaDeUsuarios;
    }

}
