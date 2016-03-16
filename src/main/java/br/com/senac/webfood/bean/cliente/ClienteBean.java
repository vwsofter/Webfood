/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.bean.cliente;

import br.com.senac.webfood.banco.ClienteDAO;
import br.com.senac.webfood.bean.Bean;
import br.com.senac.webfood.modelo.Cliente;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author sala306b
 */
@Named(value = "ClienteBean")
@RequestScoped
public class ClienteBean extends Bean {

    private Cliente cliente;
    private final ClienteDAO dao = new ClienteDAO();

    public ClienteBean() {
        if (this.cliente == null) {
            this.limpar();
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setcliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String salvar() {

        try {

            if (this.cliente.getId() == 0) {
                dao.save(cliente);
                addMessageInfo("Salvo com sucesso !");
            } else {
                dao.update(cliente);
                addMessageInfo("Alterado com sucesso !");
            }

        } catch (Exception ex) {
            addMessageError(ex.getMessage());
        }

        return null;
    }

    public String editar(){
        return"/admin/cliente/cadastroCliente";
    }
  

    private void limpar() {
        this.cliente = new Cliente();
    }

}
