/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.gov.health.vmis.jsf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.faces.FacesException;
import javax.annotation.Resource;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import lk.gov.health.vmis.beans.VehicleFacade;
import lk.gov.health.vmis.entities.Vehicle;
import lk.gov.health.vmis.jsf.util.JsfUtil;
import lk.gov.health.vmis.jsf.util.PagingInfo;

/**
 *
 * @author Lenovo
 */
public class VehicleController {

    public VehicleController() {
        pagingInfo = new PagingInfo();
        converter = new VehicleConverter();
    }
    private Vehicle vehicle = null;
    private List<Vehicle> vehicleItems = null;
    private VehicleFacade jpaController = null;
    private VehicleConverter converter = null;
    private PagingInfo pagingInfo = null;
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "vmis")
    private EntityManagerFactory emf = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(getJpaController().count());
        }
        return pagingInfo;
    }

    public VehicleFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (VehicleFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "vehicleJpa");
        }
        return jpaController;
    }

    public SelectItem[] getVehicleItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getVehicleItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public Vehicle getVehicle() {
        if (vehicle == null) {
            vehicle = (Vehicle) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentVehicle", converter, null);
        }
        if (vehicle == null) {
            vehicle = new Vehicle();
        }
        return vehicle;
    }

    public String listSetup() {
        reset(true);
        return "vehicle_list";
    }

    public String createSetup() {
        reset(false);
        vehicle = new Vehicle();
        return "vehicle_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(vehicle);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Vehicle was successfully created.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("vehicle_detail");
    }

    public String editSetup() {
        return scalarSetup("vehicle_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        vehicle = (Vehicle) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentVehicle", converter, null);
        if (vehicle == null) {
            String requestVehicleString = JsfUtil.getRequestParameter("jsfcrud.currentVehicle");
            JsfUtil.addErrorMessage("The vehicle with id " + requestVehicleString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String vehicleString = converter.getAsString(FacesContext.getCurrentInstance(), null, vehicle);
        String currentVehicleString = JsfUtil.getRequestParameter("jsfcrud.currentVehicle");
        if (vehicleString == null || vehicleString.length() == 0 || !vehicleString.equals(currentVehicleString)) {
            String outcome = editSetup();
            if ("vehicle_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit vehicle. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(vehicle);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Vehicle was successfully updated.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return detailSetup();
    }

    public String remove() {
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentVehicle");
        Long id = new Long(idAsString);
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().remove(getJpaController().find(id));
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Vehicle was successfully deleted.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return relatedOrListOutcome();
    }

    private String relatedOrListOutcome() {
        String relatedControllerOutcome = relatedControllerOutcome();
        if (relatedControllerOutcome != null) {
            return relatedControllerOutcome;
        }
        return listSetup();
    }

    public List<Vehicle> getVehicleItems() {
        if (vehicleItems == null) {
            getPagingInfo();
            vehicleItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return vehicleItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "vehicle_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "vehicle_list";
    }

    private String relatedControllerOutcome() {
        String relatedControllerString = JsfUtil.getRequestParameter("jsfcrud.relatedController");
        String relatedControllerTypeString = JsfUtil.getRequestParameter("jsfcrud.relatedControllerType");
        if (relatedControllerString != null && relatedControllerTypeString != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Object relatedController = context.getApplication().getELResolver().getValue(context.getELContext(), null, relatedControllerString);
            try {
                Class<?> relatedControllerType = Class.forName(relatedControllerTypeString);
                Method detailSetupMethod = relatedControllerType.getMethod("detailSetup");
                return (String) detailSetupMethod.invoke(relatedController);
            } catch (ClassNotFoundException e) {
                throw new FacesException(e);
            } catch (NoSuchMethodException e) {
                throw new FacesException(e);
            } catch (IllegalAccessException e) {
                throw new FacesException(e);
            } catch (InvocationTargetException e) {
                throw new FacesException(e);
            }
        }
        return null;
    }

    private void reset(boolean resetFirstItem) {
        vehicle = null;
        vehicleItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Vehicle newVehicle = new Vehicle();
        String newVehicleString = converter.getAsString(FacesContext.getCurrentInstance(), null, newVehicle);
        String vehicleString = converter.getAsString(FacesContext.getCurrentInstance(), null, vehicle);
        if (!newVehicleString.equals(vehicleString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
