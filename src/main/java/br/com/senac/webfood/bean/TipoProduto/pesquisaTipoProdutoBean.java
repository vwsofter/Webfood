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


import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author sala306b
 */
@Named(value = "pesquisaTipoProdutoBean")
@ViewScoped
public class pesquisaTipoProdutoBean extends Bean {
    private Long id;
    private String descricao;
    private Boolean ativo;
  
    private final TipoProdutoDAO dao= new TipoProdutoDAO();
    private List<TipoProduto> listaTipoProdutosFiltrados;
    
    
    
     
  public pesquisaTipoProdutoBean(){
          
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
    
    public List<TipoProduto> getListaTipoProdutosFiltrados() {
        return listaTipoProdutosFiltrados;
    }
   
    public void setListaTipoProdutoFiltrados(List<TipoProduto> listaTipoProdutosFiltrados ){
        this.listaTipoProdutosFiltrados = listaTipoProdutosFiltrados;
        
   }
public void pesquisar() {
        try {
            this.listaTipoProdutosFiltrados = dao.getTipoProdutoByFiltro(id, descricao, ativo);
        } catch (Exception ex) {
            addMessageError(ex.getMessage());
        }
  
      }



    public void excluir(TipoProduto tipoProduto) {
        try {
            dao.delete(tipoProduto);
            this.listaTipoProdutosFiltrados.remove(tipoProduto);
            addMessageInfo("Tipo de Produto" + tipoProduto.getId() + " removido com sucesso!");
        } catch (Exception ex) {
            addMessageError("Não foi possivel remover o Tipo de Produto.");
        }

    }

        
        

        
        
        
    }  
        
    

  
  
     
     

