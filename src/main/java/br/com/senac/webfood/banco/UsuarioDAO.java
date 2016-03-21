/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.banco;

import br.com.senac.webfood.modelo.Usuario;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author sala306b
 */
public class UsuarioDAO extends DAO<Usuario> {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public List<Usuario> findByFiltro(Long id, String nome, String email, String login, Boolean ativo) {

        List<Usuario> listaUsuario = null;

        StringBuilder sb = new StringBuilder("from Usuario u where 1 = 1 ");

        if (id != null) {
            sb.append(" and u.id = :Id");
        }

        if (nome != null && !nome.equals("")) {
            sb.append(" and u.nome like :Nome");
        }

        if (login != null && !login.equals("")) {
            sb.append(" and u.login like :Login");
        }

        if (email != null && !email.equals("")) {
            sb.append(" and u.email like :Email");
        }

        if (ativo != null) {
            sb.append(" and u.ativo = :Ativo");
        }

        this.em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        Query query = em.createQuery(sb.toString());

        if (id != null) {
            query.setParameter("Id", id);
        }

        if (nome != null && !nome.equals("")) {
            query.setParameter("Nome", nome + "%");
        }

        if (login != null && !login.equals("")) {
            query.setParameter("Login", login + "%");
        }

        if (email != null && !email.equals("")) {
            query.setParameter("Email", email + "%");
        }

        if (ativo != null) {
            query.setParameter("Ativo", ativo);
        }

        listaUsuario = query.getResultList();
        em.getTransaction().commit();
        em.close();

        return listaUsuario;
    }

    public Usuario getByEmail(String email) {

        Usuario usuario = null;
        try {
            this.em = JPAUtil.getEntityManager();

            usuario = this.em.createQuery("from Usuario where lower(email) = :email", Usuario.class)
                    .setParameter("email", email.toLowerCase()).getSingleResult();
        } catch (NoResultException ex) {
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return usuario;

    }

}
