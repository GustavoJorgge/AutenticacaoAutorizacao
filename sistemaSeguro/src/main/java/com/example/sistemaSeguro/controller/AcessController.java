package com.example.sistemaSeguro.controller;

import com.example.sistemaSeguro.infra.security.JwtUtil;
import com.example.sistemaSeguro.model.UsuarioEntity;
import com.example.sistemaSeguro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AcessController {

    @Autowired
    private UsuarioService usuarioService;
    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody UsuarioEntity dados){
        System.out.println("Chegou aqui");
        Optional<UsuarioEntity> usuarioEntity = usuarioService.findByNomeUsuario(dados.getNomeUsuario());
        if(usuarioEntity.isEmpty()){
            UsuarioEntity newUsuario = new UsuarioEntity(dados.getNomeUsuario(), dados.getSenha(), dados.getTipoConta());
            usuarioService.cadastrarUsuario(newUsuario);
            String token = JwtUtil.generateToken(newUsuario.getNomeUsuario());
            return ResponseEntity.ok(token);
        }
        return  ResponseEntity.badRequest().build();
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

    @GetMapping("/username/{token}")
    public String extractUsername(@PathVariable String token) {
        String username = usuarioService.extractUsername(token);
        return username;
    }
}
