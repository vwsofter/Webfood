/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.banco;

import br.com.senac.webfood.modelo.FormaPagamento;
import java.util.List;
import static jdk.nashorn.internal.runtime.Debug.id;
import static org.hibernate.criterion.Projections.id;

import java.util.Collections;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author sala306b
 */
public class FormaPagamentoDAO extends DAO<FormaPagamento> {

    public FormaPagamentoDAO() {
        super(FormaPagamento.class);
    }

    public List<FormaPagamento> getFormaPagamentosbyFiltro(Long id, String descricao, Boolean parcela, Boolean ativo) {

        List<FormaPagamento> listaformaPagamento;

        StringBuilder sb = new StringBuilder("from FormaPagamento c where 1 = 1 ");

        if (id != null) {
            sb.append("and c.id = : Id");
        }

        if (descricao != null && !descricao.equals("")) {
            sb.append(" and c.descricao like :Descricao");
        }

        if (ativo != null) {
            sb.append("and c.ativo = :Ativo");

        }

        if (parcela != null) {
            sb.append("and c.parcela = :Parcela");

        }
        this.em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        Query query = em.createQuery(sb.toString());

        if (id() != null) {
            query.setParameter("Id", id);
        }

        if (descricao != null && !descricao.equals("")) {
            query.setParameter("Descricao", descricao + "%");
        }
        if (ativo != null) {
            query.setParameter("Ativo", ativo);
        }

        if (parcela != null) {
            query.setParameter("Parcela", parcela);
        }

        listaformaPagamento = query.getResultList();
        em.getTransaction().commit();
        em.close();

        return listaformaPagamento;

    }

    public List<FormaPagamento> getByFiltro(Long id, String descricao, Boolean parcela, Boolean ativo) {
        List<FormaPagamento> listaFormaPagamento;

        String sql = "from FormaPagamento f "
                + "where "
                + "( :Id is null or (:Id is not null and f.id = :Id)) "
                + "and (:Descricao is null or  (:Descricao is not null and f.descricao = :Descricao)) "
                + "and (:Parcela is null  or (:Parcela is not null and f.parcela = :Parcela)) "
                + "and (:Ativo is null or (:Ativo is not null and f.ativo = :Ativo)) ";

        this.em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        Query query = em.createQuery(sql);

        query.setParameter("Id", id);

        if (descricao != null && !descricao.equals("")) {
            query.setParameter("Descricao", descricao + "%");
        } else {
            query.setParameter("Descricao", null);
        }

        query.setParameter("Parcela", parcela);

        query.setParameter("Ativo", ativo);

        listaFormaPagamento = query.getResultList();
        em.getTransaction().commit();
        em.close();

        return listaFormaPagamento;
    }
}
