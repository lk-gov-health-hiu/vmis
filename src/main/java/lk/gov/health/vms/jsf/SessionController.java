/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package lk.gov.health.vms.jsf;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import lk.gov.health.vms.entities.Institution;
import lk.gov.health.vms.entities.WebUser;

/**
 *
 * @author Lenovo
 */
@Named(value = "sessionController")
@SessionScoped
public class SessionController implements Serializable {
    
    WebUser webuser;
    Institution institution;
    String username;
    String password;

    public WebUser getWebuser() {
        return webuser;
    }

    public void setWebuser(WebUser webuser) {
        this.webuser = webuser;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Creates a new instance of SessionController
     */
    public SessionController() {
    }

    public String checkuser() {

        return "/home?faces-redirect=true";
    }
    
}
