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
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author sala306b
 */
@Named(value = "formaPagamentoBean")
@RequestScoped
public class formaPagamentoBean extends Bean {

    private FormaPagamento formaPagamento;
    private final FormaPagamentoDAO dao = new FormaPagamentoDAO();

    public formaPagamentoBean() {
        if (this.formaPagamento == null) {
            this.limpar();
        }
    }
    
    public List<FormaPagamento> getListaFormaPagamentos(){
        return dao.findAll() ;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String salvar() {

        try {

            if (this.formaPagamento.getId() == 0) {
                dao.save(formaPagamento);
                addMessageInfo("Salvo com sucesso !");
            } else {
                dao.update(formaPagamento);
                addMessageInfo("Alterado com sucesso !");
            }

        } catch (Exception ex) {
            addMessageError(ex.getMessage());
        }

        return null;
    }

    public String editar() {
        return "/admin/formaPagamento/cadastroFormaPagamento";
    }

    private void limpar() {
        this.formaPagamento = new FormaPagamento();
    }

}
