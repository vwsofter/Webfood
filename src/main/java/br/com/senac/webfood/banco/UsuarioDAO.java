/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.banco;
import br.com.senac.webfood.modelo.Usuario;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author daniel
 */
public class UsuarioDAO extends DAO<Usuario> {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public List<Usuario> getUsuarioByFiltro(Long id, String login,String senha,String nome,String email,Boolean ativo)  {

        List<Usuario> listaUsuarios;

        StringBuilder sb = new StringBuilder("from Usuario c where 1 = 1 ");

        if (id != null) {
            sb.append(" and c.id = :Id");
        }

        if (login != null && !login.equals("")) {
            sb.append(" and c.descricao like :Login");
        }

        if (ativo != null) {
            sb.append(" and c.ativo = :Ativo");
        }

        this.em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        Query query = em.createQuery(sb.toString());

        if (id != null) {
            query.setParameter("Id", id);
        }

        if (login != null && !login.equals("")) {
            query.setParameter("Login", login + "%");
        }

        if (ativo != null) {
            query.setParameter("Ativo", ativo);
        }

        listaUsuarios = query.getResultList();
        em.getTransaction().commit();
        em.close();

        return listaUsuarios;

    }
}


