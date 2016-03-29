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
    private double precoPadrao;
    @ManyToOne
    private TipoProduto tipoProduto;

    public boolean isPermitecomplemento() {
        return permitecomplemento;
    }

    public void setPermitecomplemento(boolean permitecomplemento) {
        this.permitecomplemento = permitecomplemento;
    }
    private boolean permitecomplemento;
    
    public Produto() {
        this.tipoProduto = new TipoProduto();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoPadrao() {
        return precoPadrao;
    }

    public void setPrecoPadrao(double precoPadrao) {
        this.precoPadrao = precoPadrao;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

}
