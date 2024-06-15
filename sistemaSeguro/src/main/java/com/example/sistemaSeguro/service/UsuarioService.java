package com.example.sistemaSeguro.service;

import com.example.sistemaSeguro.infra.security.JwtUtil;
import com.example.sistemaSeguro.model.UsuarioEntity;
import com.example.sistemaSeguro.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioEntity cadastrarUsuario(UsuarioEntity user){
        System.out.println(user);
        return usuarioRepository.save(user);
    }

    public Optional<UsuarioEntity> findByNomeUsuario(String nome_Usuario) {
        return usuarioRepository.findByNomeUsuario(nome_Usuario);
    }

    public String extractUsername(String token) {
        String username = JwtUtil.extractUsername(token);
        return username;
    }


}
