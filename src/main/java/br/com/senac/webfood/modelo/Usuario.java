/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sala306b
 */
@Entity
public class Usuario extends Entidade {
    
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false, unique = true)
    private String email;
    private String senha;
    private String nome;
    private String trocaSenha;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataUltimaAtualizacao;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Grupo> grupos;
    
    public Usuario() {
        this.grupos = new ArrayList<>();
    }
    
    public String getTrocaSenha() {
        return trocaSenha;
    }
    
    public void setTrocaSenha(String trocaSenha) {
        this.trocaSenha = trocaSenha;
    }
    
    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }
    
    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    private boolean bloqueado;
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean isBloqueado() {
        return bloqueado;
    }
    
    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Grupo> getGrupos() {
        return grupos;
    }
    
    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }
    
    @PreUpdate
    @PrePersist
    public void setLastUpdate() {
        this.dataUltimaAtualizacao = new Date();
    }
    
}
