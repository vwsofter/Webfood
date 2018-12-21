/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.modelo;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;

@Entity
public class Pedido extends Entidade {

    @ManyToOne
    private Cliente cliente;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataAbertura;
    private String observação;
    private int quantidadeParcelas;
    
    @ManyToOne
    private FormaPagamento formaPagamento;
    @OneToMany
    private List<ItemDePedido> itens;

    
    

    @Transient
    private double total;

    public Pedido() {
        this.cliente = new Cliente();
        this.formaPagamento = new FormaPagamento();
        this.itens = new ArrayList<>();
        this.dataAbertura = new Date();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getObservação() {
        return observação;
    }

    public void setObservação(String observação) {
        this.observação = observação;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    
    

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public List<ItemDePedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemDePedido> itens) {
        this.itens = itens;
    }

    

    public void add(ItemDePedido itemDePedido) {
        this.itens.add(itemDePedido);
    }

    public void remove(ItemDePedido itemDePedido) {
        this.itens.remove(itemDePedido);
    }

    public double getTotal() {
        this.total = 0;

        for (ItemDePedido i : this.itens) {
            this.total += i.getTotal();
        }
        return this.total;
    }

    public String totalFormatado() {
        NumberFormat format = NumberFormat.getCurrencyInstance();

        return format.format(total);
    }

}
