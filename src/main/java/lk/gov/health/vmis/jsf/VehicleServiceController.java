/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.gov.health.vmis.jsf;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lk.gov.health.vmis.entities.VehicleService;

/**
 *
 * @author Lenovo
 */
public class VehicleServiceController {

    private VehicleService vehicleService = new VehicleService();
    @EJB 
    private  lk.gov.health.vmis.beans.VehicleServiceFacade ejbFacade;
    
 
  //------------------------------------------ Insert data
    
      public VehicleService getvehicleservise(){
          
          if (vehicleService==null){
              
              vehicleService=new VehicleService();
          }
          return vehicleService;
      }
      
      public void setvehicleservise(){
          
          this.vehicleService=vehicleService;
      }
      
      
    
    public void insertdayta(){
        
       ejbFacade.create(vehicleService);
    }
    
    //---------------------------------------------------------
    
}
