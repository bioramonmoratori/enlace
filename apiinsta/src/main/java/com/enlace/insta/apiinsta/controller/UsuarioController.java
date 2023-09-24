package com.enlace.insta.apiinsta.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enlace.insta.apiinsta.components.Forms.AutenticacaoForm;
import com.enlace.insta.apiinsta.components.Forms.ContatoForm;
import com.enlace.insta.apiinsta.components.Forms.PostForm;
import com.enlace.insta.apiinsta.components.Forms.UsuarioForm;
import com.enlace.insta.apiinsta.service.AutenticacaoService;
import com.enlace.insta.apiinsta.service.ContatosService;
import com.enlace.insta.apiinsta.service.UsuarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/instaapi/usuario")
public class UsuarioController {
    
    public static final String API_INSTAGRAM_URL = "http://localhost:8000/";

    @Autowired
    UsuarioForm usuarioForm;

    @Autowired
    PostForm postForm;

    @Autowired
    AutenticacaoService autenticacaoService;

    @Autowired
    ContatosService contatosService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ContatoForm contatoForm;

    @GetMapping("/")
    public ResponseEntity<?> conexao(){
        return ResponseEntity.ok("Conexão com o servidor estabelecida");
    }

    @PostMapping("/autenticacao")
    public ResponseEntity<?> autenticacao(@RequestBody AutenticacaoForm autenticacaoForm){

        String autentication_url = API_INSTAGRAM_URL + "auth/login";
        String username_id_url = API_INSTAGRAM_URL + "user/id_from_username";
        
        String sessionID = autenticacaoService.autenticacao(autentication_url, 
            autenticacaoForm.getUsername(), autenticacaoForm.getPassword());
        
        String username_id = autenticacaoService.obterIDDoUsuario(username_id_url, 
            autenticacaoForm.getUsername(), sessionID);

        usuarioForm.setSessionID(sessionID);
        usuarioForm.setUserID(username_id);

        return ResponseEntity.ok(usuarioForm);
        
    }

    @PostMapping("/seguidores")
    public ResponseEntity<?> seguidores(@RequestBody UsuarioForm usuarioForm){

        String user_followers_url = API_INSTAGRAM_URL + "user/followers";
        List<ContatoForm> seguidores = contatosService.seguidores(user_followers_url, usuarioForm.getSessionID(), usuarioForm.getUserID());

        return ResponseEntity.ok(seguidores);
    }

    @RequestMapping("/seguindo")
    public ResponseEntity<?> seguindo(@RequestBody UsuarioForm usuarioForm){

        String user_following_url = API_INSTAGRAM_URL + "user/following";
        List<ContatoForm> seguidores = contatosService.seguidores(user_following_url, usuarioForm.getSessionID(), usuarioForm.getUserID());

        return ResponseEntity.ok(seguidores);
    }

    @RequestMapping("/listadeposts")
    public ResponseEntity<?> listaDePosts(@RequestBody UsuarioForm usuarioForm){

        String user_medias_url = API_INSTAGRAM_URL + "media/user_medias";
        List<String> listaDePosts = usuarioService.posts(user_medias_url, usuarioForm.getSessionID(), usuarioForm.getUserID());

        return ResponseEntity.ok(listaDePosts);
    }

    @RequestMapping("/curtidasdopost")
    public ResponseEntity<?> curtidasDoPost(@RequestBody PostForm postForm){

        String media_likers_url = API_INSTAGRAM_URL + "media/likers";
        List<String> curtidasDoPost = contatosService.contatosQueCurtiramOPost(media_likers_url, postForm.getSessionID(), postForm.getMediaID());

        return ResponseEntity.ok(curtidasDoPost);
    }

}
