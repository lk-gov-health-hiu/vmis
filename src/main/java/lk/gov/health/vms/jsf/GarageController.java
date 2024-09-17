/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package lk.gov.health.vms.jsf;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.gov.health.vms.beans.GarageFacade;
import lk.gov.health.vms.entities.Garage;
import lk.gov.health.vms.jsf.util.JsfUtil;

/**
 *
 * @author Theminda
 */
@Named
@SessionScoped
public class GarageController implements Serializable {

    @EJB
    private GarageFacade garageFacade;
    @PersistenceContext
    private EntityManager entityManager;

    private List<Garage> items = null;

    private Garage current;

    private Garage selected;

    public GarageFacade getGarageFacade() {
        return garageFacade;
    }

    public void setGarageFacade(GarageFacade garageFacade) {
        this.garageFacade = garageFacade;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Garage> getItems() {
        return items;
    }

    public void setItems(List<Garage> items) {
        this.items = items;
    }

    public Garage getCurrent() {
        return current;
    }

    public void setCurrent(Garage current) {
        this.current = current;
    }

    public Garage getSelected() {
        return selected;
    }

    public void setSelected(Garage selected) {
        this.selected = selected;
    }

    public String navigateToAdd() {
        current = new Garage();
        return "/garage/create?faces-redirect=true";
    }
    
    public String navigateToList() {
        items = garageFacade.findAll();
        return "/garage/list?faces-redirect=true";
    }

    //Register Garage------------------------------------------
    public String save() {
        if (current == null) {
            JsfUtil.addErrorMessage("No Garage");
            return null;
        }
        if (current.getId() == null) {
            garageFacade.create(current);
            items.add(current);
            JsfUtil.addSuccessMessage("New Garage Saved");
        } else {
            garageFacade.edit(current);
            JsfUtil.addSuccessMessage("Garage Details Updated.");
        }
        return navigateToList();
    }

}
//    public void create() {
//
//        try {
//            garage1.setName(selected.getName());
//            garage1.setAddress(selected.getAddress());
//            garage1.setEmail(selected.getEmail());
//            garage1.setContact(selected.getContact());
//            garage1.setWhatsappnum(selected.getWhatsappnum());
//            garage1.setType(selected.getType());
//            garageFacade.create(garage1);
//            JsfUtil.addSuccessMessage("Garage saved successfully");
//
//        } catch (Exception ex) {
//            JsfUtil.addErrorMessage("Error....!");
//        }
//
//    }
