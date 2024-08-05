/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.gov.health.vms.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.gov.health.vms.entities.FuelTransaction;

/**
 *
 * @author buddh
 */
@Stateless
public class FuelTransactionFacade extends AbstractFacade<FuelTransaction> {

    @PersistenceContext(unitName = "em")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FuelTransactionFacade() {
        super(FuelTransaction.class);
    }
    
}
