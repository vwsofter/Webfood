/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.banco;

import br.com.senac.webfood.modelo.TipoProduto;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author sala306b
 */
public class TipoProdutoDAO extends DAO<TipoProduto> {
    
    public TipoProdutoDAO() {
        super(TipoProduto.class);
    }
    
    public List<TipoProduto> getTipoProdutoByFiltro(Long id, String descricao, Boolean ativo){
        
        List<TipoProduto> listaTipoProdutos;
        
        StringBuilder sb = new StringBuilder("from TipoProduto c where 1 = 1 ");
        
        if(id != null){
            sb.append(" and c.id = :Id");
        }
        
        if(descricao != null && !descricao.equals("")){
            sb.append(" and c.descricao like :Descricao");
        }
        
        if(ativo != null){
            sb.append("and c.ativo = :Ativo");
        }
        
        this.em = JPAUtil.getEntityManager();
        
        em.getTransaction().begin();
        Query query = em.createNamedQuery(sb.toString());
        
        if(id != null) {
            query.setParameter("Id", id);
        }
        
        if(descricao != null && !descricao.equals("")){
            query.setParameter("Descricao", descricao + "%");
        }
        
        if(ativo != null){
            query.setParameter("Ativo", ativo);
        }
        
        listaTipoProdutos = query.getResultList();
        em.getTransaction().commit();
        em.close();
        
        return listaTipoProdutos;
    }
    
}
