/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.bean.cliente;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Wagner Xavier
 */
@Named(value = "clienteBean")
@RequestScoped
public class ClienteBean {

    /**
     * Creates a new instance of ClienteBean
     */
    public ClienteBean() {
    }
    
}
