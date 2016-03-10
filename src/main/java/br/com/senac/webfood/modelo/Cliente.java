/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author sala306b
 */
@Entity
public class Cliente extends Entidade {

    @Column(nullable = false)
    private String nome;
   
    
   
  
    @ManyToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @ManyToOne
    private Telefone telefone;

    public Cliente() {
        this.endereco = new Endereco();
        this.telefone = new Telefone();
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

 


  

  

 

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

}
