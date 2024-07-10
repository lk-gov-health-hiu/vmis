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
import lk.gov.health.vmis.beans.FuelTransactionFacade;
import lk.gov.health.vmis.entities.FuelTransaction;
import lk.gov.health.vmis.jsf.util.JsfUtil;
import lk.gov.health.vmis.jsf.util.PagingInfo;

/**
 *
 * @author Lenovo
 */
public class FuelTransactionController {

    public FuelTransactionController() {
        pagingInfo = new PagingInfo();
        converter = new FuelTransactionConverter();
    }
    private FuelTransaction fuelTransaction = null;
    private List<FuelTransaction> fuelTransactionItems = null;
    private FuelTransactionFacade jpaController = null;
    private FuelTransactionConverter converter = null;
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

    public FuelTransactionFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (FuelTransactionFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "fuelTransactionJpa");
        }
        return jpaController;
    }

    public SelectItem[] getFuelTransactionItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getFuelTransactionItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public FuelTransaction getFuelTransaction() {
        if (fuelTransaction == null) {
            fuelTransaction = (FuelTransaction) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentFuelTransaction", converter, null);
        }
        if (fuelTransaction == null) {
            fuelTransaction = new FuelTransaction();
        }
        return fuelTransaction;
    }

    public String listSetup() {
        reset(true);
        return "fuelTransaction_list";
    }

    public String createSetup() {
        reset(false);
        fuelTransaction = new FuelTransaction();
        return "fuelTransaction_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(fuelTransaction);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("FuelTransaction was successfully created.");
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
        return scalarSetup("fuelTransaction_detail");
    }

    public String editSetup() {
        return scalarSetup("fuelTransaction_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        fuelTransaction = (FuelTransaction) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentFuelTransaction", converter, null);
        if (fuelTransaction == null) {
            String requestFuelTransactionString = JsfUtil.getRequestParameter("jsfcrud.currentFuelTransaction");
            JsfUtil.addErrorMessage("The fuelTransaction with id " + requestFuelTransactionString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String fuelTransactionString = converter.getAsString(FacesContext.getCurrentInstance(), null, fuelTransaction);
        String currentFuelTransactionString = JsfUtil.getRequestParameter("jsfcrud.currentFuelTransaction");
        if (fuelTransactionString == null || fuelTransactionString.length() == 0 || !fuelTransactionString.equals(currentFuelTransactionString)) {
            String outcome = editSetup();
            if ("fuelTransaction_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit fuelTransaction. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(fuelTransaction);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("FuelTransaction was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentFuelTransaction");
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
                JsfUtil.addSuccessMessage("FuelTransaction was successfully deleted.");
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

    public List<FuelTransaction> getFuelTransactionItems() {
        if (fuelTransactionItems == null) {
            getPagingInfo();
            fuelTransactionItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return fuelTransactionItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "fuelTransaction_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "fuelTransaction_list";
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
        fuelTransaction = null;
        fuelTransactionItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        FuelTransaction newFuelTransaction = new FuelTransaction();
        String newFuelTransactionString = converter.getAsString(FacesContext.getCurrentInstance(), null, newFuelTransaction);
        String fuelTransactionString = converter.getAsString(FacesContext.getCurrentInstance(), null, fuelTransaction);
        if (!newFuelTransactionString.equals(fuelTransactionString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
