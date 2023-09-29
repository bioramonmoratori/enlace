package com.enlace.api.component.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.enlace.api.component.auth.SecurityFilter;

@Configuration
@EnableWebSecurity // Habilita as configuracoes personalizadas de seguranca
public class SecurityConfig {
    
    // ROLE_USER
    // ROLE_ADMIN

    @Autowired
    SecurityFilter securityFilter;

    // Cadeia de verificacoes para confirmar se o usuario esta apto a usar a aplicacao
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
        .csrf(csrf -> csrf.disable()) // Desativa a configuracao padrao de pagina de login
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        // Autenticacao Stateless (nao armazenamos as informacoes do usuario logado)
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
            .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
            .requestMatchers(HttpMethod.GET, "/api/usuario").hasAnyRole("USER", "ADMIN")
            .anyRequest().authenticated())
            //Determino que o filtro securityFilter ocorra antes do filtro de autenticacao usernamepassword
            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
    }

    @Bean
    public AuthenticationManager authenticationManager
        (AuthenticationConfiguration authenticationConfiguration) throws Exception {

        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
