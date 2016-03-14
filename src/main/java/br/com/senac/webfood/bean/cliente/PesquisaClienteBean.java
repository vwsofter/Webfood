/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.bean.cliente;

import br.com.senac.webfood.banco.ClienteDAO;
import br.com.senac.webfood.bean.Bean;
import br.com.senac.webfood.modelo.Cliente;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "pesquisaClienteBean")
@ViewScoped
public class PesquisaClienteBean extends Bean {

    private Long id;
    private String nome;
    
  
    private Boolean ativo;

    private final ClienteDAO dao = new ClienteDAO();

    private List<Cliente> listaClientesFiltrado;

    public PesquisaClienteBean() {

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

    public List<Cliente> getListaClientesFiltrado() {
        return listaClientesFiltrado;
    }

    public void setListaClientesFiltrado(List<Cliente> listaClientesFiltrado) {
        this.listaClientesFiltrado = listaClientesFiltrado;
    }

    public void pesquisar() {
        try {
            this.listaClientesFiltrado = dao.getClienteByFiltros(id, nome, nome, nome, nome, nome, nome, ativo);
        } catch (Exception ex) {
           
        }

    }
    
 
    

    public void excluir(Cliente cliente) {
        try {
            dao.delete(cliente);
            this.listaClientesFiltrado.remove(cliente);
            addMessageInfo("Categoria" + cliente.getId() + " removido com sucesso!");
        } catch (Exception ex) {
           
        }

    }

}
