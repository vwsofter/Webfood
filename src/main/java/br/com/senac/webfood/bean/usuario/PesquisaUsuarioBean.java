/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.bean.usuario;

import br.com.senac.webfood.banco.UsuarioDAO;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

import br.com.senac.webfood.bean.Bean;
import br.com.senac.webfood.modelo.Usuario;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "PesquisaUsuarioBean")
@ViewScoped
public class PesquisaUsuarioBean extends Bean {

    private Long id;
    private String descricao;
    private Boolean ativo;

    private final UsuarioDAO dao = new UsuarioDAO();

    private List<Usuario> listaUsuarioFiltrado;

    public PesquisaUsuarioBean() {

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

    public List<Usuario> getListaUsuariosFiltrado() {
        return listaUsuarioFiltrado;
    }

    public void setListaUsuarioFiltrado(List<Usuario> listaUsuariosFiltrado) {
        this.listaUsuarioFiltrado = listaUsuariosFiltrado;
    }

    public void pesquisar() {
        try {
            this.listaUsuarioFiltrado = dao.;
        } catch (Exception ex) {
            addMessageError(ex.getMessage());
        }

    }

    public void excluir(Categoria categoria) {
        try {
            dao.delete(categoria);
            this.listaCategoriasFiltrado.remove(categoria);
            addMessageInfo("Categoria " + categoria.getId() + " removido com sucesso!");
        } catch (Exception ex) {
            addMessageError(ex.getMessage());
        }

    }
}
