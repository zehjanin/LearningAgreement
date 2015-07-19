/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fachklassen.LehrveranstaltungAusland;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import managedBeans.loginBean;


/**
 *
 * @author Janina
 */
@FacesConverter(forClass=LehrveranstaltungAusland.class, value="categoryConverter")
public class CategoryConverter implements Converter {
      @EJB
    private LAHandler lahandler;
 

   
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
     if (value.isEmpty()) {
            return null;
        }
     else{
        Long id = new Long (value);
        System.out.println(value);
        return lahandler.findeLVA(id);
     }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return "" + ((LehrveranstaltungAusland) value).getLehrveranstaltungsnummer();
    }
}