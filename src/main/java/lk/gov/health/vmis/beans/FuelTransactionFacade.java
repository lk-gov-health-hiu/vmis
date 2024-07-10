/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.gov.health.vmis.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.gov.health.vmis.entities.FuelTransaction;

/**
 *
 * @author Lenovo
 */
@Stateless
public class FuelTransactionFacade extends AbstractFacade<FuelTransaction> {

    @PersistenceContext(unitName = "vmis")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FuelTransactionFacade() {
        super(FuelTransaction.class);
    }
    
}
