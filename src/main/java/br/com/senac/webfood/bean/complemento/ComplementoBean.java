/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.bean.complemento;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.senac.webfood.banco.ComplementoDAO;
import br.com.senac.webfood.bean.Bean;
import br.com.senac.webfood.modelo.Complemento;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author daniel
 */
@Named(value = "complementoBean")
@RequestScoped
public class ComplementoBean extends Bean {

    private String[] selectedComplemento; 
    private List<Complemento> complementos;
    
     private Complemento complemento;
    
    private final ComplementoDAO dao = new ComplementoDAO ();

    public ComplementoBean() {
        if (this.complemento == null) {
            this.limpar();
        }
    }

    public Complemento getComplemento() {
        return complemento;
    }

    public List<Complemento> getListaComplementos(){
        return dao.findAll() ;
    }
  

    public String salvar() {

        try {

            if (this.complemento.getId() == 0) {
                dao.save(complemento);
                addMessageInfo("Salvo com sucesso !");
            } else {
                dao.update(complemento);
                addMessageInfo("Alterado com sucesso !");
            }

        } catch (Exception ex) {
            addMessageError(ex.getMessage());
        }

        return null;
    }

    public String editar() {
        return "/admin/Complementos/CadastrodeComplementos";
    }

    private void limpar() {
        this.complemento = new Complemento();
    }

    public String[] getSelectedComplemento() {
        return selectedComplemento;
    }

    public void setSelectedComplemento(String[] selectedComplemento) {
        this.selectedComplemento = selectedComplemento;
    }

}


