package com.enlace.insta.apiinsta.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.enlace.insta.apiinsta.components.Forms.ContatoForm;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ContatosService {
    
    @Autowired
    private RestTemplate restTemplate;

    //Serve para obter seguidores e seguindo
    public List<ContatoForm> seguidores(String url, String sessionID, String userID){

        // Configurar os parâmetros no formato x-www-form-urlencoded
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("sessionid", sessionID);
        params.add("user_id", userID);

        // Configurar os cabeçalhos da requisição
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // Criar a entidade de requisição com os parâmetros e cabeçalhos
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        // Enviar a requisição POST
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        // Pegando o nome dos contatos de quem segue o usuario
        String json = responseEntity.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        List<ContatoForm> listaDeUsuarios = new ArrayList<>();
        Map<String, JsonNode> mapaDeUsuarios = new HashMap<>();

        try {
            // Converte o JSON em um mapa onde a chave é uma String e o valor é um JsonNode
            mapaDeUsuarios = objectMapper.readValue(json, new TypeReference<Map<String, JsonNode>>() {});
            
            // Itera pelo mapa de usuários e obtém o atributo 'full_name' de cada um
            for (Map.Entry<String, JsonNode> entry : mapaDeUsuarios.entrySet()) {
                JsonNode user = entry.getValue();
                String usuario = user.get("username").asText();
                String fotoDePerfilURL = user.get("profile_pic_url").asText();

                ContatoForm contato = new ContatoForm();
                contato.setUsuario(usuario);
                contato.setFotoDePerfilURL(fotoDePerfilURL);
                listaDeUsuarios.add(contato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaDeUsuarios;

    }

    public List<String> contatosQueCurtiramOPost(String url, String sessionID, String mediaID){

        // Configurar os parâmetros no formato x-www-form-urlencoded
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("sessionid", sessionID);
        params.add("media_id", mediaID);
        //params.add("amount", "5");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        // Enviar a requisição POST
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        // Pegando o JSON da resposta
        String json = responseEntity.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        List<String> listaDeUsernames = new ArrayList<>();

        try {
            // Converte o JSON em um array de objetos JSON
            JsonNode jsonNode = objectMapper.readTree(json);
            if (jsonNode.isArray()) {
                for (JsonNode node : jsonNode) {
                    String username = node.get("username").asText();
                    listaDeUsernames.add(username);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaDeUsernames;

    }

}
