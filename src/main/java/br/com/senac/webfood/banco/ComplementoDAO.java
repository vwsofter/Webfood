/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.banco;

import br.com.senac.webfood.modelo.Complemento;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author wagner
 */
public class ComplementoDAO extends DAO<Complemento> {

    public ComplementoDAO() {
        super(Complemento.class);
    }

    public List<Complemento> getComplementosByFiltro(Long id, String descricao, Boolean ativo)  {

        List<Complemento> listaComplementos;

        StringBuilder sb = new StringBuilder("from Complemento c where 1 = 1 ");

        if (id != null) {
            sb.append(" and c.id = :Id");
        }

        if (descricao != null && !descricao.equals("")) {
            sb.append(" and c.descricao like :Descricao");
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

        if (descricao != null && !descricao.equals("")) {
            query.setParameter("Descricao", descricao + "%");
        }

        if (ativo != null) {
            query.setParameter("Ativo", ativo);
        }

        listaComplementos = query.getResultList();
        em.getTransaction().commit();
        em.close();

        return listaComplementos;

    }
     public String[] getSelectedComplemento() {
        return selectedComplemento;
    }

    public void setSelectedComplemento(String[] selectedComplemento) {
        this.selectedComplemento = selectedComplemento;
    }
     private String[] selectedComplemento;  

}
