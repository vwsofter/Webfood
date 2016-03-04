package br.com.senac.webfood.modelo;

import javax.persistence.ManyToOne;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class ItemDePedido extends Entidade{
    
    @ManyToOne
    private Produto produto;
    private int quantidade;
  
    private TipoProduto tipoProduto;
    private Complemento complemento;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Complemento getComplemento() {
        return complemento;
    }

    public void setComplemento(Complemento complemento) {
        this.complemento = complemento;
    }

}
