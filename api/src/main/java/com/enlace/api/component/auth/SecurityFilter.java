package com.enlace.api.component.auth;

import java.io.IOException;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.enlace.api.component.interfaces.repository.UsuarioRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
//Filtro de uma vez por requisicao, por isso extende a classe
public class SecurityFilter extends OncePerRequestFilter{
    
    UsuarioRepository usuarioRepository;

    @Autowired
    TokenService tokenService;

    // Pega o token e recupera as informacoes dele
    @Override
    protected void doFilterInternal(HttpServletRequest request, 
        HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var token = recoverToken(request); 
            
        if(token != null){
            var email = "";
            try {
                email = tokenService.validateToken(token);
            } catch (AuthenticationException e) {
                e.printStackTrace();
            }
            UserDetails user = usuarioRepository.findByEmail(email);

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response); // Chama o proximo filtro das configuracoes de seguranca


    }

    private String recoverToken(HttpServletRequest request){
        
        var authHeader = request.getHeader("Authorization");

        if(authHeader == null){
            return null;
        }
        return authHeader.replace("Bearer ", "");
    }

}
