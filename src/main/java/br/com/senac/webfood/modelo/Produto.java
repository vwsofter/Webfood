/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.modelo;

/**
 *
 * @author Wagner Xavier
 */
public class Produto extends Entidade{
    private String descricao;
    private TipoProduto tipodeproduto;
    private boolean situacao;
    private double valorunitario;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoProduto getTipodeproduto() {
        return tipodeproduto;
    }

    public void setTipodeproduto(TipoProduto tipodeproduto) {
        this.tipodeproduto = tipodeproduto;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public double getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(double valorunitario) {
        this.valorunitario = valorunitario;
    }


    
    
    
    
    
}
