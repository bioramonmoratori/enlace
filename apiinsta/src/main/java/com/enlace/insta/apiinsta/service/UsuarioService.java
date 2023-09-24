package com.enlace.insta.apiinsta.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UsuarioService {
    
    @Autowired
    private RestTemplate restTemplate;

    public List<String> posts(String url, String sessionID, String userID) {

        // Configurar os parâmetros no formato x-www-form-urlencoded
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("sessionid", sessionID);
        params.add("user_id", userID);
        //params.add("amount", "5");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        // Enviar a requisição POST
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        // Pegando o JSON da resposta
        String json = responseEntity.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        List<String> listaDePostID = new ArrayList<>();

        try {
            // Converte o JSON em um array de objetos JSON
            JsonNode jsonNode = objectMapper.readTree(json);
            if (jsonNode.isArray()) {
                for (JsonNode node : jsonNode) {
                    String postID = node.get("id").asText();
                    listaDePostID.add(postID);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaDePostID;
    }
}
