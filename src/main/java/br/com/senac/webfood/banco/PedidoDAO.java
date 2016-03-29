/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.banco;

import br.com.senac.webfood.modelo.Cliente;
import br.com.senac.webfood.modelo.FormaPagamento;
import br.com.senac.webfood.modelo.Pedido;
import br.com.senac.webfood.modelo.TipoProduto;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;


/**
 *
 * @author sala306b
 */
public class PedidoDAO extends DAO<Pedido>{
    
    public PedidoDAO() {
        super(Pedido.class);
    }
    
    @SuppressWarnings("null")
    public List<Pedido> getPedidoByFiltro(Long id, String nome, Boolean ativo){
        
        List<Pedido> listaPedido = null;
        
        StringBuilder sb = new StringBuilder("from Pedido p where 1 = 1");
        
        if(id != null){
            sb.append(" and p.id = :Id");
        }
        
        if(nome != null && !nome.equals("")){
            sb.append(" and p.nome like :Nome");
        }
                       
        if(ativo != null ){
            sb.append(" and p.ativo = :Ativo");
        }
        
        this.em = JPAUtil.getEntityManager();
        
        em.getTransaction().begin();
        Query query = em.createQuery(sb.toString());
        
        if(id != null && id != 0 ){
            query.setParameter("Id", id);
        }
        
        if(nome != null){
            query.setParameter("Nome", nome + "%");
            
        }
        
      
        
        if(ativo != null ){
            query.setParameter("Ativo", ativo);
        }
        
        
        return listaPedido;
        
        
        
        
    }

   
    
}