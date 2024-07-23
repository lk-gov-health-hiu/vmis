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
import lk.gov.health.vmis.beans.DriverFacade;
import lk.gov.health.vmis.entities.Driver;
import lk.gov.health.vmis.jsf.util.JsfUtil;
import lk.gov.health.vmis.jsf.util.PagingInfo;

/**
 *
 * @author Lenovo
 */
public class DriverController {

    public DriverController() {
        pagingInfo = new PagingInfo();
        converter = new DriverConverter();
    }
    private Driver driver = null;
    private List<Driver> driverItems = null;
    private DriverFacade jpaController = null;
    private DriverConverter converter = null;
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

    public DriverFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (DriverFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "driverJpa");
        }
        return jpaController;
    }

    public SelectItem[] getDriverItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getDriverItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public Driver getDriver() {
        if (driver == null) {
            driver = (Driver) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentDriver", converter, null);
        }
        if (driver == null) {
            driver = new Driver();
        }
        return driver;
    }

    public String listSetup() {
        reset(true);
        return "driver_list";
    }

    public String createSetup() {
        reset(false);
        driver = new Driver();
        return "driver_create";
    }
    public String createSetup1() {
        // Perform any setup actions needed
        return "create?faces-redirect=true"; // Redirects to create.xhtml
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(driver);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Driver was successfully created.");
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
        return scalarSetup("driver_detail");
    }

    public String editSetup() {
        return scalarSetup("driver_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        driver = (Driver) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentDriver", converter, null);
        if (driver == null) {
            String requestDriverString = JsfUtil.getRequestParameter("jsfcrud.currentDriver");
            JsfUtil.addErrorMessage("The driver with id " + requestDriverString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String driverString = converter.getAsString(FacesContext.getCurrentInstance(), null, driver);
        String currentDriverString = JsfUtil.getRequestParameter("jsfcrud.currentDriver");
        if (driverString == null || driverString.length() == 0 || !driverString.equals(currentDriverString)) {
            String outcome = editSetup();
            if ("driver_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit driver. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(driver);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Driver was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentDriver");
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
                JsfUtil.addSuccessMessage("Driver was successfully deleted.");
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

    public List<Driver> getDriverItems() {
        if (driverItems == null) {
            getPagingInfo();
            driverItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return driverItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "driver_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "driver_list";
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
        driver = null;
        driverItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Driver newDriver = new Driver();
        String newDriverString = converter.getAsString(FacesContext.getCurrentInstance(), null, newDriver);
        String driverString = converter.getAsString(FacesContext.getCurrentInstance(), null, driver);
        if (!newDriverString.equals(driverString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
