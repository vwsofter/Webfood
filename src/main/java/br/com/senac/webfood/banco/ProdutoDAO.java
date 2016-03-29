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
    
   public List<Produto> getProdutoByFiltro(Long id, String descricao, Boolean ativo, Long idTipoProduto)  {

        List<Produto> listaProduto;

        StringBuilder sb = new StringBuilder("from Produto p join p.tipoProduto t where 1 = 1 ");

        if (id != null && id != 0) {
            sb.append(" and p.id = :Id");
        }

        if (descricao != null && !descricao.equals("")) {
            sb.append(" and p.descricao like :Descricao");
        }

        if (ativo != null) {
            sb.append(" and p.ativo = :Ativo");
        }
        
         if (idTipoProduto != null && idTipoProduto != 0) {
            sb.append(" and t.id = :IdTipoProduto");
        }
      

        this.em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        Query query = em.createQuery(sb.toString());

        if (id != null && id != 0) {
            query.setParameter("Id", id);
        }

        if (descricao != null && !descricao.equals("")) {
            query.setParameter("Descricao", descricao + "%");
        }

        if (ativo != null) {
            query.setParameter("Ativo", ativo);
        }
        
         if (idTipoProduto != null && idTipoProduto != 0) {
            query.setParameter("IdTipoProduto", idTipoProduto);
        }
        
      
        

        listaProduto = query.getResultList();
        em.getTransaction().commit();
        em.close();

        return listaProduto;
        
        
   }
        
    public List<Produto> findByNome(String descricao) {

        List<Produto> listaProduto;

        String sql = "from Produto s where s.descricao like :Descricao ";

        this.em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        Query query = em.createQuery(sql);

        query.setParameter("Descricao",  descricao + "%");

        listaProduto = query.getResultList();
        em.getTransaction().commit();
        em.close();
        

        return listaProduto;
        
        

    }
    
}
