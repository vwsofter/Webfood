/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.bean.pedido;

import br.com.senac.webfood.banco.PedidoDAO;
import br.com.senac.webfood.bean.Bean;
import br.com.senac.webfood.modelo.Pedido;
import java.util.Date;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Junior
 */
@Named(value = "pesquisapedidoBean")
@ViewScoped
public class pesquisapedidoBean extends Bean{
    
    private Long id;
    private String nome;
    
    private Boolean ativo;
    
    private final PedidoDAO dao = new PedidoDAO();
    
    private List<Pedido> listaPedidoFiltrado;
    
    public pesquisapedidoBean(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<Pedido> getListaPedidoFiltrado() {
        return listaPedidoFiltrado;
    }

    public void setListaPedidoFiltrado(List<Pedido> listaPedidoFiltrado) {
        this.listaPedidoFiltrado = listaPedidoFiltrado;
    }
    
    public void pesquisar(){
        try {
            Date dataEntrega = null;
            this.listaPedidoFiltrado = dao.getPedidoByFiltro(id, nome, ativo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    public  void excluir(Pedido pedido){
        
        try {
            dao.delete(pedido);
            this.listaPedidoFiltrado.remove(pedido);
            addMessageInfo("Pedido" + pedido.getId() + "removido com sucesso !!");
        } catch (Exception ex) {
            addMessageError(ex.getMessage());
        }
        
    }

    
}
