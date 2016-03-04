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

}
