/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.gov.health.vmis.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import lk.gov.health.vmis.entities.FuelTransaction;

/**
 *
 * @author Lenovo
 */
public class FuelTransactionConverter implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        Long id = new Long(string);
        FuelTransactionController controller = (FuelTransactionController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "fuelTransaction");
        return controller.getJpaController().find(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof FuelTransaction) {
            FuelTransaction o = (FuelTransaction) object;
            return o.getId() == null ? "" : o.getId().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: lk.gov.health.vmis.entities.FuelTransaction");
        }
    }
    
}
