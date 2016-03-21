/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.bean.usuario;

import br.com.senac.webfood.banco.UsuarioDAO;
import br.com.senac.webfood.bean.Bean;
import br.com.senac.webfood.modelo.Usuario;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author daniel
 */
@Named(value = "pesquisaUsuarioBean")
@ViewScoped
public class PesquisaUsuarioBean extends Bean {

    private Long id;
    private String nome;
    private String login;
    private String email;
    private Boolean ativo;

    private final UsuarioDAO dao = new UsuarioDAO();

    private List<Usuario> listaUsuarioFiltrado;

    public PesquisaUsuarioBean() {

    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<Usuario> getListaUsuarioFiltrado() {
        return listaUsuarioFiltrado;
    }

    public void setListaUsuarioFiltrado(List<Usuario> listaUsuarioFiltrado) {
        this.listaUsuarioFiltrado = listaUsuarioFiltrado;
    }

    public void pesquisar() {
        try {
            this.listaUsuarioFiltrado = dao.findByFiltro(id, nome.trim(), email.trim(), login.trim(), ativo);
        } catch (Exception ex) {
            addMessageError(ex.getMessage());
        }

    }

    public void excluir(Usuario usuario) {
        try {
            dao.delete(usuario);
            this.listaUsuarioFiltrado.remove(usuario);
            addMessageInfo("Usuário " + usuario.getNome()+ " excluido com sucesso!");
        } catch (Exception ex) {
            addMessageError(ex.getMessage());
        }

    }

}
