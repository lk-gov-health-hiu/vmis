/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.gov.health.vms.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.gov.health.vms.entities.Garage;


/**
 *
 * @author Lenovo
 */
@Stateless
public class GarageFacade extends AbstractFacade<Garage> {

    @PersistenceContext(unitName = "em")
    private EntityManager em;
    
     @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public GarageFacade() {
        super(Garage.class);
    }
    
}
