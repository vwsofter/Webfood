/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.banco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel
 */
public class JPAUtil {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebFoodPU");

    public static EntityManager getEntityManager() {

        try {
            return emf.createEntityManager();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Erro ao acessar banco de dados!");
        }

    }

}
