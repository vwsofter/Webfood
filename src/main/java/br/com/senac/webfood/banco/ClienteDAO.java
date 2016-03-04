/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.banco;


import br.com.senac.webfood.modelo.Cliente;
import java.util.List;
import javax.persistence.Query;

public class ClienteDAO extends DAO<Cliente>{
    
    public ClienteDAO() {
        super(Cliente.class);
    }
 
    
    
}