/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.bean.FormaPagamento;

import br.com.senac.webfood.banco.FormaPagamentoDAO;

import br.com.senac.webfood.bean.Bean;
import br.com.senac.webfood.modelo.FormaPagamento;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author sala306b
 */
@Named(value = "pesquisaFormaPagamentoBean")
@ViewScoped
public class pesquisaFormaPagamentoBean extends Bean {

    private Long id;
    private String descricao;
    private Boolean parcela;
    private Boolean ativo;

    private final FormaPagamentoDAO dao = new FormaPagamentoDAO();
    private List<FormaPagamento> listadePagamentos;

    public pesquisaFormaPagamentoBean() {
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

    public Boolean getParcela() {
        return parcela;
    }

    public void setParcela(Boolean parcela) {
        this.parcela = parcela;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<FormaPagamento> getListadePagamentos() {
        return listadePagamentos;
    }

    public void setListadePagamentos(List<FormaPagamento> listadePagamentos) {
        this.listadePagamentos = listadePagamentos;
    }

    public void pesquisar() {
        try {
            this.listadePagamentos = dao.getByFiltro(id, descricao.trim(), parcela, ativo);
        } catch (Exception ex) {
            addMessageError(ex.getMessage());
        }

    }

    public void excluir(FormaPagamento formaPagamento) {
        try {
            dao.delete(formaPagamento);
            this.listadePagamentos.remove(formaPagamento);
            addMessageInfo("Forma de Pagamento " + formaPagamento.getId() + " removido com sucesso!");
        } catch (Exception ex) {
            addMessageError(ex.getMessage());
        }
    }
}
