/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.bean.produto;

import br.com.senac.webfood.banco.ProdutoDAO;
import br.com.senac.webfood.bean.Bean;
import br.com.senac.webfood.modelo.Produto;

import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author sala306b
 */
@Named(value = "pesquisaProdutoBean")
@ViewScoped
public class PesquisaProdutoBean extends Bean {

    private Long id;
    private String descricao;
    private Boolean ativo;

    private final ProdutoDAO dao = new ProdutoDAO();

    private List<Produto> listaProdutos;

    public PesquisaProdutoBean() {
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

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public void pesquisar() {
        try {
            this.listaProdutos = dao.getProdutosByFiltro(Long.MIN_VALUE, descricao, ativo);
        } catch (Exception ex) {
            addMessageError(ex.getMessage());
        }

    }

    public void excluir(Produto produto) {
        try {
            dao.delete(produto);
            this.listaProdutos.remove(produto);
            addMessageInfo("Produto " + produto.getId() + " removido com sucesso!");
        } catch (Exception ex) {
            addMessageError(ex.getMessage());
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
