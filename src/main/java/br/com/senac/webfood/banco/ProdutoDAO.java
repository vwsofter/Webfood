/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.banco;

import br.com.senac.webfood.modelo.Produto;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author sala306b
 */

public class ProdutoDAO extends DAO<Produto>{
   

   public ProdutoDAO (){
       super(Produto.class);
   } 
    
   public List<Produto> getProdutosByFiltro(Long id, String descricao, Boolean ativo)  {

        List<Produto> listaProdutos;

        StringBuilder sb = new StringBuilder("from Produto s where 1 = 1 ");

        if (id != null) {
            sb.append(" and s.id = :Id");
        }

        if (descricao != null && !descricao.equals("")) {
            sb.append(" and s.descricao like :Descricao");
        }

        if (ativo != null) {
            sb.append(" and s.ativo = :Ativo");
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
        
      

        listaProdutos = query.getResultList();
        em.getTransaction().commit();
        em.close();

        return listaProdutos;
 
}
}