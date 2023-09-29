package com.enlace.api.component.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enlace.api.component.interfaces.repository.UsuarioRepository;
import com.enlace.api.model.Usuario;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/auth")
public class TokenController {
    
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> token(@RequestBody @Valid AutenticacaoDto autenticacaoDto) {

        if(usuarioRepository.findByEmail(autenticacaoDto.getEmail()) == null){
            return ResponseEntity.badRequest().build();
        }

        //Login e senha juntas, formando um token
        var usernamePassword = new UsernamePasswordAuthenticationToken(autenticacaoDto.getEmail(), autenticacaoDto.getSenha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        // auth.getPrincipal pega o usuario autenticado
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDto(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegistroDto registroDto){

        if(usuarioRepository.findByEmail(registroDto.getEmail()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(registroDto.getSenha());
        Usuario usuario = new Usuario();
        usuario.setEmail(registroDto.getEmail());
        usuario.setSenha(encryptedPassword);
        usuario.setRole(registroDto.getRole());
        
        usuario.setPronome(registroDto.getPronome());
        usuario.setNome(registroDto.getNome());
        usuario.setCidade(registroDto.getCidade());


        usuarioRepository.save(usuario);

        return ResponseEntity.ok().build();
    }

}
