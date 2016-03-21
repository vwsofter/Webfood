/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author daniel
 */
@Entity
public class Grupo extends Entidade {

    @Column(nullable = false , length = 40)
    private String nome;
    @Column(nullable = false , length = 40)
    private String decricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDecricao() {
        return decricao;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

}
