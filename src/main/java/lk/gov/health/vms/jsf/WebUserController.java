package lk.gov.health.vms.jsf;

import lk.gov.health.vms.entities.WebUser;
import lk.gov.health.vms.jsf.util.JsfUtil;
import lk.gov.health.vms.jsf.util.JsfUtil.PersistAction;
import lk.gov.health.vms.beans.WebUserFacade;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import lk.gov.health.enums.WebuserRole;
import org.jasypt.util.password.StrongPasswordEncryptor;

@Named("webUserController")
@SessionScoped
public class WebUserController implements Serializable {

    @EJB
    private lk.gov.health.vms.beans.WebUserFacade ejbFacade;
    private List<WebUser> items = null;
    private WebUser selected;
    String password;
    private String oldPassword;

    public WebUserController() {
    }

    public String navigateToAddNewUser() {
        selected = new WebUser();
        return "/webUser/add_new_user?faces-redirect=true";
    }

    public String navigateToViewUser() {
        if (selected == null) {
            JsfUtil.addErrorMessage("No User");
            return null;
        }
        return "/webUser/view_user?faces-redirect=true";
    }

    public String navigateToEditUser() {
        if (selected == null) {
            JsfUtil.addErrorMessage("No User");
            return null;
        }
        return "/webUser/edit_user?faces-redirect=true";
    }

    public String navigateToListUsers() {
        items = fillAllUsers();
        return "/webUser/list_users?faces-redirect=true";
    }

    public String navigateToChangePassword() {
        if (selected == null) {
            JsfUtil.addErrorMessage("No User");
            return null;
        }
        return "/webUser/change_password?faces-redirect=true";
    }

    private List<WebUser> fillAllUsers() {
        String jpql = "select renuka "
                + " from WebUser renuka "
                + " where renuka.retired=:ret ";
        HashMap params = new HashMap();
        params.put("ret", false);
        return getFacade().findByJpql(jpql, params);
    }

    public String changeOldPassword() {
        if (selected == null) {
            JsfUtil.addErrorMessage("No user");
            return null;
        }
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        String plainPassword = password;
        String hashedPassword = passwordEncryptor.encryptPassword(plainPassword);
        System.out.println("Hashed Password: " + hashedPassword);
        selected.setPassword(hashedPassword);
        getFacade().edit(selected);
        JsfUtil.addSuccessMessage("Password changed");
        return navigateToListUsers();
    }

    public WebUser getSelected() {
        return selected;
    }

    public void setSelected(WebUser selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private WebUserFacade getFacade() {
        return ejbFacade;
    }

    public WebUser prepareCreate() {
        selected = new WebUser();
        initializeEmbeddableKey();
        return selected;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public WebuserRole[] getWebuserRoles() {
        return WebuserRole.values();
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("WebUserCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public String saveNewUser() {
        if (selected == null) {
            JsfUtil.addErrorMessage("No User");
            return null;
        }

        if (selected.getName().trim().equals("")) {
            JsfUtil.addErrorMessage("No name");
            return null;
        }

        if (selected.getUsername().trim().equals("")) {
            JsfUtil.addErrorMessage("No Username");
            return null;
        }
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

        String hashedPassword = passwordEncryptor.encryptPassword(password);
        selected.setPassword(hashedPassword);
        if (selected.getId() == null) {
            getFacade().create(selected);
        } else {
            getFacade().edit(selected);
        }
        JsfUtil.addSuccessMessage("New User Added");
        return navigateToListUsers();
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("WebUserUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("WebUserDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<WebUser> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public WebUser getWebUser(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<WebUser> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<WebUser> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    @FacesConverter(forClass = WebUser.class)
    public static class WebUserControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            WebUserController controller = (WebUserController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "webUserController");
            return controller.getWebUser(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof WebUser) {
                WebUser o = (WebUser) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), WebUser.class.getName()});
                return null;
            }
        }

    }

}
