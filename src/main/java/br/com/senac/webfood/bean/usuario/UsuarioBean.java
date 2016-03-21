/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.bean.usuario;

import br.com.senac.webfood.banco.UsuarioDAO;
import br.com.senac.webfood.bean.Bean;
import br.com.senac.webfood.modelo.Usuario;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author daniel
 */
@Named(value = "usuarioBean")
@RequestScoped
public class UsuarioBean extends Bean {

    private Usuario usuario;
    private final UsuarioDAO dao = new UsuarioDAO();

    public UsuarioBean() {
        if (this.usuario == null) {
            this.limpar();
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String salvar() {

        try {

            if (this.usuario.getId() == 0) {
                dao.save(usuario);
                addMessageInfo("Salvo com sucesso !");
            } else {
                dao.update(usuario);
                addMessageInfo("Alterado com sucesso !");
            }

        } catch (Exception ex) {
            addMessageError(ex.getMessage());
        }

        return null;
    }

    public String editar() {
        return "/admin/usuario/cadastroUsuario";
    }

    private void limpar() {
        this.usuario = new Usuario();
    }

}
