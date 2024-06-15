package com.example.sistemaSeguro.model;

import jakarta.persistence.*;


@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_usuario")
    private String nomeUsuario;

    private String senha;

    @Column(name = "tipo_conta")
    private String tipoConta; // Renomeado para seguir convenções Java

    public UsuarioEntity() {}

    public UsuarioEntity(String nomeUsuario, String senha, String tipoConta) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.tipoConta = tipoConta;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
}
