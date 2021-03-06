/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.banco;

import br.com.senac.webfood.modelo.Cliente;
import br.com.senac.webfood.modelo.Produto;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author sala306b
 */
public class ClienteDAO extends DAO<Cliente> {

    public ClienteDAO() {
        super(Cliente.class);
    }

    public List<Cliente> getClienteByFiltros(Long id, String nome, String telefone1, String telefone2, String endereco, String bairro, String pontoReferencia, Boolean ativo) {

        List<Cliente> listaCliente;

        StringBuilder sb = new StringBuilder("from Cliente c where 1 = 1 ");

        if (id != null) {
            sb.append(" and c.id = :Id");
        }

        if (nome != null && !nome.equals("")) {
            sb.append(" and c.nome like :Nome");
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

        if (nome != null && !nome.equals("")) {
            query.setParameter("Nome", nome + "%");
        }
      
        
       
        if (ativo != null) {
            query.setParameter("Ativo", ativo);
        }

        listaCliente = query.getResultList();
        em.getTransaction().commit();
        em.close();

        return listaCliente;
        

     
   
    }
        public List<Cliente> findByNome(String descricao) {

        List<Cliente> listaCliente;

        String sql = "from Cliente s where s.descricao like :Descricao ";

        this.em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        Query query = em.createQuery(sql);

        query.setParameter("Descricao",  descricao + "%");

        listaCliente = query.getResultList();
        em.getTransaction().commit();
        em.close();
        

        return listaCliente;
        
        

    }

}
