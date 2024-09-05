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
@Named(value = "garageController")
@SessionScoped
public class GarageController implements Serializable {

    @EJB
    private lk.gov.health.vms.beans.GarageFacade ejbbeans;
    @PersistenceContext
    private EntityManager entityManager;
    
    private List<Garage> items1 = null;
       
    private Garage currentgarage;
    
    private Garage selected;

  
    public GarageFacade getEjbbeans() {
        return ejbbeans;
    }

    public void setEjbbeans(GarageFacade ejbbeans) {
        this.ejbbeans = ejbbeans;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Garage> getItems1() {
        return items1;
    }

    public void setItems1(List<Garage> items1) {
        this.items1 = items1;
    }

    public Garage getCurrentgarage() {
        return currentgarage;
    }

    public void setCurrentgarage(Garage currentgarage) {
        this.currentgarage = currentgarage;
    }

    public Garage getSelected() {
        return selected;
    }

    public void setSelected(Garage selected) {
        this.selected = selected;
    }
    
      public String NavigateToAdd() {

        currentgarage = new Garage();
        return "/garage/create?faces-redirect=true";
    }
   
      //Register Garage------------------------------------------
    
    
     public void create(){
         
         if(currentgarage==null){
              
             currentgarage=new Garage();
             ejbbeans.create(currentgarage);
         }
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
//            ejbbeans.create(garage1);
//            JsfUtil.addSuccessMessage("Garage saved successfully");
//
//        } catch (Exception ex) {
//            JsfUtil.addErrorMessage("Error....!");
//        }
//
//    }