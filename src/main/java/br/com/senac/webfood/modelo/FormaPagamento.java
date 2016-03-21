/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.modelo;

import javax.persistence.Entity;

@Entity
public class FormaPagamento extends Entidade {

    private String descricao;
    private boolean parcela;
    private int quantidadeMaximaParcela;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isParcela() {
        return parcela;
    }

    public void setParcela(boolean parcela) {
        this.parcela = parcela;
    }

    public int getQuantidadeMaximaParcela() {
        return quantidadeMaximaParcela;
    }

    public void setQuantidadeMaximaParcela(int quantidadeMaximaParcela) {
        this.quantidadeMaximaParcela = quantidadeMaximaParcela;
    }

}
