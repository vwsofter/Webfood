/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class ItemDePedido extends Entidade {

    @ManyToOne
    private Produto produto;
    private int quantidade;
    private double precoUnitario;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Complemento> listaComplemento ; 

    public List<Complemento> getListaComplemento() {
        return listaComplemento;
    }

    public void setListaComplemento(List<Complemento> listaComplemento) {
        this.listaComplemento = listaComplemento;
    }
    
    
    
    @Transient
    private double total;

    public ItemDePedido() {
        this.produto = new Produto();
        this.listaComplemento = new ArrayList<>();
    }

    public ItemDePedido(Produto produto, int quantidade, double precoUnitario, List<Complemento> listaComplemento) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.listaComplemento = listaComplemento;
    }

    

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

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getTotal() {
        this.total = this.quantidade * this.precoUnitario;
        return this.total;
    }

}
