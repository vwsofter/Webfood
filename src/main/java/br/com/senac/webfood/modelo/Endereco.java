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
 * @author daniel
 */
@Entity
public class Endereco extends Entidade {

    private String logradouro;
    private long cep;
    private String bairro;
    private String cidade;
    private int numero;
    private String pontoreferecia;
    @ManyToOne
    private Uf uf;

 
    

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public long getCep() {
        return cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPontoreferecia() {
        return pontoreferecia;
    }

    public void setPontoreferecia(String pontoreferecia) {
        this.pontoreferecia = pontoreferecia;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }


  

}