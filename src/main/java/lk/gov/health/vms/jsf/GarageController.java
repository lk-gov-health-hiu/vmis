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
import lk.gov.health.vms.entities.Garage;
import lk.gov.health.vms.jsf.util.JsfUtil;

/**
 *
 * @author Theminda
 */
@Named(value = "garageController")
@SessionScoped
public class GarageController implements Serializable {

    @EJB
    private lk.gov.health.vms.beans.GarageFacade ejbbeans;
    @PersistenceContext
    private EntityManager entityManager;
    private Garage garage1 = new Garage();
    private Garage selected;
    private List<Garage> items1 = null;

    public GarageController() {

    }

    public Garage getSelected() {
        return selected;
    }

    public Garage getGarage1() {
        return garage1;
    }

    public void setGarage1(Garage garage1) {
        this.garage1 = garage1;
    }

    public void create() {

        try {
            garage1.setName(selected.getName());
            garage1.setAddress(selected.getAddress());
            garage1.setEmail(selected.getEmail());
            garage1.setContact(selected.getContact());
            garage1.setWhatsappnum(selected.getWhatsappnum());
            garage1.setType(selected.getType());
            ejbbeans.create(garage1);
            JsfUtil.addSuccessMessage("Garage saved successfully");

        } catch (Exception ex) {
            JsfUtil.addErrorMessage("Error....!");
        }

    }

    public String NavigateToAdd() {

        selected = new Garage();
        return "/garage/create?faces-redirect=true";
    }

}
