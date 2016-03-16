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
 * @author sala306b
 */
@Entity
public class itemPedido extends Entidade{

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(double valorUnit) {
        this.valorUnit = valorUnit;
    }
    @Column(nullable = false)
    private int quantidade;
    private double valorUnit;
    
    
    
    
}
