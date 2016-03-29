/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Gleison
 */
@Entity
public class Complemento extends Entidade {

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    private String[] selectedComplemento;
    @OneToMany
    private List<Complemento> complementos;

    public String[] getSelectedComplemento() {
        return selectedComplemento;
    }

    public void setSelectedComplemento(String[] selectedComplemento) {
        this.selectedComplemento = selectedComplemento;
    }

    public List<Complemento> getComplementos() {
        return complementos;
    }

    public void setComplementos(List<Complemento> complementos) {
        this.complementos = complementos;
    }

}
