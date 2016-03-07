/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.bean.complemento;

import br.com.senac.webfood.banco.ComplementoDAO;
import br.com.senac.webfood.bean.Bean;
import br.com.senac.webfood.modelo.Complemento;
import com.sun.corba.se.spi.orbutil.fsm.Guard;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author daniel
 */
@Named(value = "pesquisaComplementoBean")
@ViewScoped
public class PesquisaComplementoBean extends Bean {

    private Long id;
    private String descricao;
    private Boolean ativo;

    private final ComplementoDAO dao = new ComplementoDAO();

    private List<Complemento> listaComplementosFiltrado;

    public PesquisaComplementoBean() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Complemento> getListaComplementosFiltrado() {
        return listaComplementosFiltrado;
    }

    public void setListaComplementoFiltrado(List<Complemento> listaComplementosFiltrado) {
        this.listaComplementosFiltrado = listaComplementosFiltrado;
    }

    public void pesquisar() {
        try {
            this.listaComplementosFiltrado = dao.getComplementosByFiltro(id, descricao, ativo);
        } catch (Exception ex) {
            addMessageError(ex.getMessage());
        }

    }

    public void excluir(Complemento complemento) {
        try {
            dao.delete(complemento);
            this.listaComplementosFiltrado.remove(complemento);
            addMessageInfo("Complemento " + complemento.getId() + " removido com sucesso!");
        } catch (Exception ex) {
            addMessageError("Não foi possivel remover o Complemento registro.");
        }

    }

}
