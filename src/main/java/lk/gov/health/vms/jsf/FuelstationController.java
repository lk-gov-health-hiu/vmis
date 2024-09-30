/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package lk.gov.health.vms.jsf;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.gov.health.vms.beans.FuelStationFacade;
import lk.gov.health.vms.entities.FuelStation;
import lk.gov.health.vms.jsf.util.JsfUtil;

/**
 *
 * @author Theminda
 */
@Named
@SessionScoped
public class FuelstationController implements Serializable {

    /**
     * Creates a new instance of FuelstationController
     */
    public FuelstationController() {
    }
    @EJB
    private FuelStationFacade fuelStationFacade;
    @PersistenceContext
    private EntityManager entityManager;

    private List<FuelStation> items = null;

    private FuelStation current;
    private FuelStation selected;

    public FuelStationFacade getFuelStationFacade() {
        return fuelStationFacade;
    }

    public void setFuelStationFacade(FuelStationFacade fuelStationFacade) {
        this.fuelStationFacade = fuelStationFacade;
    }
    

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<FuelStation> getItems() {
        if (items == null) {
            items = new ArrayList<>();
        }
        return items;
    }

    public void setItems(List<FuelStation> items) {
        this.items = items;
    }

    public FuelStation getCurrent() {

        return current;
    }

    public void setCurrent(FuelStation current) {
        this.current = current;
    }

    public FuelStation getSelected() {
        return selected;
    }

    public void setSelected(FuelStation selected) {
        this.selected = selected;
    }

    public String save() {

        if (current == null) {
            JsfUtil.addErrorMessage("No Fuel station selected");
            return null;
        }
        if (current.getId() == null) {
            fuelStationFacade.create(current);
            getItems().add(current);
            JsfUtil.addSuccessMessage("Fuel station saved");
        } else {
            fuelStationFacade.edit(current);
            JsfUtil.addSuccessMessage("Fuel station updated");
        }
        return navigatolist1();
    }

    public String navigateToAdd1() {
        current = new FuelStation();
        return "/fuelstation/create?faces-redirect=true";
    }

    public String navigatolist1() {

        items = fuelStationFacade.findAll();
        return "/fuelstation/list?faces-redirect=true";
    }
}
