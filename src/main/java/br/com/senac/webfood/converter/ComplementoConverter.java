/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senac.webfood.converter;

import br.com.senac.webfood.banco.ComplementoDAO;
import br.com.senac.webfood.modelo.Complemento;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("complemento")
public class ComplementoConverter implements Converter {

    private final ComplementoDAO dao = new ComplementoDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = null;

        try {
            id = Integer.valueOf(value);
        } catch (NumberFormatException e) {
        }

        if (value != null) {
            return dao.find(id);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null && !value.equals("")) {
            Complemento complemento = (Complemento) value;
            return String.valueOf(complemento.getId());
        }
        return null;

    }
}
