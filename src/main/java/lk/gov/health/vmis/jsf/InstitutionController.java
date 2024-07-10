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
import lk.gov.health.vmis.beans.InstitutionFacade;
import lk.gov.health.vmis.entities.Institution;
import lk.gov.health.vmis.jsf.util.JsfUtil;
import lk.gov.health.vmis.jsf.util.PagingInfo;

/**
 *
 * @author Lenovo
 */
public class InstitutionController {

    public InstitutionController() {
        pagingInfo = new PagingInfo();
        converter = new InstitutionConverter();
    }
    private Institution institution = null;
    private List<Institution> institutionItems = null;
    private InstitutionFacade jpaController = null;
    private InstitutionConverter converter = null;
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

    public InstitutionFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (InstitutionFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "institutionJpa");
        }
        return jpaController;
    }

    public SelectItem[] getInstitutionItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getInstitutionItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public Institution getInstitution() {
        if (institution == null) {
            institution = (Institution) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentInstitution", converter, null);
        }
        if (institution == null) {
            institution = new Institution();
        }
        return institution;
    }

    public String listSetup() {
        reset(true);
        return "institution_list";
    }

    public String createSetup() {
        reset(false);
        institution = new Institution();
        return "institution_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(institution);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Institution was successfully created.");
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
        return scalarSetup("institution_detail");
    }

    public String editSetup() {
        return scalarSetup("institution_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        institution = (Institution) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentInstitution", converter, null);
        if (institution == null) {
            String requestInstitutionString = JsfUtil.getRequestParameter("jsfcrud.currentInstitution");
            JsfUtil.addErrorMessage("The institution with id " + requestInstitutionString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String institutionString = converter.getAsString(FacesContext.getCurrentInstance(), null, institution);
        String currentInstitutionString = JsfUtil.getRequestParameter("jsfcrud.currentInstitution");
        if (institutionString == null || institutionString.length() == 0 || !institutionString.equals(currentInstitutionString)) {
            String outcome = editSetup();
            if ("institution_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit institution. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(institution);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Institution was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentInstitution");
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
                JsfUtil.addSuccessMessage("Institution was successfully deleted.");
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

    public List<Institution> getInstitutionItems() {
        if (institutionItems == null) {
            getPagingInfo();
            institutionItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return institutionItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "institution_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "institution_list";
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
        institution = null;
        institutionItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Institution newInstitution = new Institution();
        String newInstitutionString = converter.getAsString(FacesContext.getCurrentInstance(), null, newInstitution);
        String institutionString = converter.getAsString(FacesContext.getCurrentInstance(), null, institution);
        if (!newInstitutionString.equals(institutionString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
