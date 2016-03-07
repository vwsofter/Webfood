/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.modelo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author sala306b
 */
@Entity
public class Produto extends Entidade {

    private String descricao;
    private double Preco;
    @ManyToOne
    private Complemento complemento;

    public Produto() {
        this.complemento = new Complemento();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double preco) {
        this.Preco = preco;
    }

    public Complemento getComplemento() {
        return complemento;
    }

    public void setcomplemento(Complemento complemento) {
        this.complemento = complemento;
    }

}
