/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.bean.TipoProduto;


import br.com.senac.webfood.banco.TipoProdutoDAO;
import br.com.senac.webfood.bean.Bean;
import br.com.senac.webfood.modelo.TipoProduto;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author sala306b
 */
@Named(value = "tipoProdutoBean")
@RequestScoped
public class TipoProdutoBean extends Bean{
       private TipoProduto tipoProduto;
       private final TipoProdutoDAO dao=new TipoProdutoDAO();

public TipoProdutoBean(){
    if (this.tipoProduto == null){
        this.limpar();     
    }   
}

 private void limpar() {
        this.tipoProduto = new TipoProduto();
    }

 
 public TipoProduto getTipoProduto(){
 return tipoProduto;
     
 }
 
 public void setTipoProduto(TipoProduto tipoproduto){
     this.tipoProduto=tipoproduto;
            
 }
  public List<TipoProduto> getListaProdutos(){
        return dao.findAll() ;
    }
 
     public String salvar() {

        try {

            if (this.tipoProduto.getId() == 0) {
                dao.save(tipoProduto);
                addMessageInfo("Salvo com sucesso !");
            } else {
                dao.update(tipoProduto);
                addMessageInfo("Alterado com sucesso !");
            }

        } catch (Exception ex) {
            addMessageError(ex.getMessage());
        }

        return null;
    }
  public String editar() {
        return "/admin/TipoProduto/cadastrotipoProduto";
    } 
  
   
  
}
