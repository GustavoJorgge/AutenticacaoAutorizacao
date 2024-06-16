package com.example.sistemaSeguro.controller;

import com.example.sistemaSeguro.infra.security.JwtUtil;
import com.example.sistemaSeguro.model.UsuarioEntity;
import com.example.sistemaSeguro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AcessController {

    @Autowired
    private UsuarioService usuarioService;

    @Secured("ROLE_ADMIN")
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody UsuarioEntity dados){
        System.out.println("CHEGOU AQUI");

        Optional<UsuarioEntity> usuarioEntity = usuarioService.findByNomeUsuario(dados.getNomeUsuario());
        if(usuarioEntity.isEmpty()){
            UsuarioEntity newUsuario = new UsuarioEntity(dados.getNomeUsuario(), dados.getSenha(), dados.getTipoConta());
            usuarioService.cadastrarUsuario(newUsuario);
            String token = JwtUtil.generateToken(newUsuario.getNomeUsuario());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public String login(@RequestBody UsuarioEntity body) {
        UsuarioEntity usuarioEntity = usuarioService.findByNomeUsuario(body.getNomeUsuario()).orElseThrow(() -> new RuntimeException("User Not Found"));
        if (body.getSenha().equals(usuarioEntity.getSenha())) {
            String token = JwtUtil.generateToken(body.getNomeUsuario());
            return token;
        }
        return "falhou";
    }

    @GetMapping("/todosUsuarios")
    public List<UsuarioEntity> buscaTodosUsuarios(){
        return usuarioService.buscaTodosUsuarios();
    }

    @GetMapping("/username/{token}")
    public String extractUsername(@PathVariable String token) {
        String username = usuarioService.extractUsername(token);
        return username;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin")
    public String onlyAdmin(Authentication authentication) {
        return "Admin: " + authentication.getName();
    }

    @Secured("ROLE_MODERADO")
    @GetMapping("/moderado")
    public String onlyModerado(Authentication authentication) {
        return "Usuario Moderado: " + authentication.getName();
    }
}
