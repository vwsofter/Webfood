/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.bean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author sala306b
 */
public abstract class Bean implements Serializable{
    
    public void addMessageInfo(String mensagem) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("Sucesso",
                new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, "Sucesso"));

    }

    public void addMessageError(String mensagem) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("Erro",
                new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, "Erro"));

    }

    public void addMessageWarnnig(String mensagem) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage("Aviso",
                new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, "Aviso"));

    }
}
