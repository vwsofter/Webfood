/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.bean.produto;

import br.com.senac.webfood.banco.TipoProdutoDAO;
import br.com.senac.webfood.banco.ProdutoDAO;
import br.com.senac.webfood.bean.Bean;
import br.com.senac.webfood.modelo.TipoProduto;
import br.com.senac.webfood.modelo.Produto;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author sala306b
 */
@Named(value = "produtoBean")
@RequestScoped
public class ProdutoBean extends Bean {

    private Produto produto;
    private final ProdutoDAO dao = new ProdutoDAO();
    private final TipoProdutoDAO daoTipoProdutoDAO = new TipoProdutoDAO();
    
    
    
    
    public ProdutoBean() {
        if (this.produto == null){
            this.limpar();
        }
    }
    
    public List<TipoProduto> getListaTipoProdutoAtiva(){
        return daoTipoProdutoDAO.findAllAtivo() ;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public String salvar() {

        try {

            if (this.produto.getId() == 0) {
                dao.save(produto);
                addMessageInfo("Salvo com sucesso !");
            } else {
                dao.update(produto);
                addMessageInfo("Alterado com sucesso !");
            }

        } catch (Exception ex) {
            addMessageError(ex.getMessage());
        }

        return null;
    }
    
    public String editar(){
        return "/admin/Produto/cadastroProduto";
    }

    private void limpar(){
        this.produto = new Produto();
    }
}
