package com.enlace.api.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enlace.api.component.dto.ContatoInstagramDto;
import com.enlace.api.component.dto.ColetaDeDadosInstagrapi.AutenticacaoInstagrapiFormDto;
import com.enlace.api.component.dto.ColetaDeDadosInstagrapi.ContatoInstagrapiForm;
import com.enlace.api.component.dto.ColetaDeDadosInstagrapi.UsuarioAutenticadoInstagrapiForm;
import com.enlace.api.component.exceptions.ContatoExceptions.ContatoInstagramExceptions.CriarContatoInstagramException;
import com.enlace.api.model.contato.ContatoInstagram;
import com.enlace.api.service.ColetaDeDadosInstagrapiService;
import com.enlace.api.service.ContatoInstagramService;
import com.enlace.api.service.UsuarioService;

@RestController
@RequestMapping("/api/instagram")
public class InstagrapiController {
    
    public static final String API_INSTAGRAM_URL = "http://localhost:8081/instaapi/usuario/";

    @Autowired
    ColetaDeDadosInstagrapiService coletaDeDadosInstagrapiService;

    @Autowired
    ContatoInstagramService contatoInstagramService;

    @Autowired
    UsuarioService usuarioService;

    ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/autenticacao")
    public ResponseEntity<?> autenticacaoInstagram(@RequestBody AutenticacaoInstagrapiFormDto autenticacaoForm){

        return null;

    }

    @PostMapping("/listadetodososcontatos")
    public ResponseEntity<?> listaDeTodosOsContatos(@RequestBody UsuarioAutenticadoInstagrapiForm usuarioInstagramForm) {

        String user_followers_url = API_INSTAGRAM_URL + "seguidores";
        List<ContatoInstagrapiForm> seguidores = coletaDeDadosInstagrapiService.obterTodosOsSeguidores(user_followers_url, usuarioInstagramForm.getSessionID(), usuarioInstagramForm.getUserID());

        for(ContatoInstagrapiForm seguidor : seguidores){

            ContatoInstagramDto contatoInstagramDto = new ContatoInstagramDto();

            contatoInstagramDto.setNomeDoContato(seguidor.getUsuario());
            if(seguidor.getFotoDePerfilURL().length() <= 100){
                contatoInstagramDto.setFotoDoPerfilURL(seguidor.getFotoDePerfilURL());
            }
            else{
                contatoInstagramDto.setFotoDoPerfilURL(null);
            }
            contatoInstagramDto.setContatoSegueOUsuario(true);

            ContatoInstagram contatoInstagram = modelMapper.map(contatoInstagramDto, ContatoInstagram.class);

            try {
                usuarioService.criarContatoInstagram(Long.valueOf(1),contatoInstagram);
            } catch (CriarContatoInstagramException e) {
                contatoInstagramDto = null;
            }
        }

        return ResponseEntity.ok(seguidores);

    }

}
