/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.banco;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Daniel
 */
public abstract class DAO<T> {

    protected EntityManager em;

    private final Class<T> entidade;

    public DAO(Class<T> entidade) {
        this.entidade = entidade;
    }

    public T find(long id) {
        this.em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        T t = em.find(entidade, id);
        em.getTransaction().commit();
        em.close();
        return t;
    }

    public List< T> findAll() {
        this.em = JPAUtil.getEntityManager();
        List<T> list;
        em.getTransaction().begin();
        list = em.createQuery("from " + entidade.getName() + " e")
                .getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    public List< T> findAllAtivo() {
        this.em = JPAUtil.getEntityManager();
        List<T> list;
        em.getTransaction().begin();
        Query query = em.createQuery("from " + entidade.getName()
                + " e where e.ativo=:Ativo"
                + ""
                + "");
        query.setParameter("Ativo", true);
        list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    public void save(T entity) {
        this.em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public void update(T entity) {
        this.em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();

    }

    public void delete(T entity) {
        this.em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
        em.close();
    }

}
