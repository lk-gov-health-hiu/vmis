/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.gov.health.vms.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author buddhika,Renuka Theminda Kirulapana
 */
@Entity
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String make;
    private String model;
    private String numberPlateNum;

    private String chassyNum;
    private String engineNum;
    private float EstimateFuelConsumtion;
    private String mainpurpose;
    @ManyToOne
    private Driver driver;
    private float averageFuelPerL;
    @ManyToOne
    private Institution Ownerinstitution;  //Owener institution
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date registeredDate;// Registerd date
    private String registeredAt;// who is registered  vehicle which for Health Institution
    //------------------------------------------------------------------------------------newly added attributies
   private float  enginecapacity;
   private String specialnotes;
   private String value;
   private String color;
   private Date yearofmaufacture;
  private  String calssofvehicle;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lk.gov.health.vmis.entities.Vehicle[ id=" + id + " ]";
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumberPlateNum() {
        return numberPlateNum;
    }

    public void setNumberPlateNum(String numberPlateNum) {
        this.numberPlateNum = numberPlateNum;
    }

    public String getChassyNum() {
        return chassyNum;
    }

    public void setChassyNum(String chassyNum) {
        this.chassyNum = chassyNum;
    }

    public String getEngineNum() {
        return engineNum;
    }

    public void setEngineNum(String engineNum) {
        this.engineNum = engineNum;
    }

    public float getEstimateFuelConsumtion() {
        return EstimateFuelConsumtion;
    }

    public void setEstimateFuelConsumtion(float EstimateFuelConsumtion) {
        this.EstimateFuelConsumtion = EstimateFuelConsumtion;
    }

    public String getMainpurpose() {
        return mainpurpose;
    }

    public void setMainpurpose(String mainpurpose) {
        this.mainpurpose = mainpurpose;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public float getAverageFuelPerL() {
        return averageFuelPerL;
    }

    public void setAverageFuelPerL(float averageFuelPerL) {
        this.averageFuelPerL = averageFuelPerL;
    }

    public Institution getOwnerinstitution() {
        return Ownerinstitution;
    }

    public void setOwnerinstitution(Institution Ownerinstitution) {
        this.Ownerinstitution = Ownerinstitution;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(String registeredAt) {
        this.registeredAt = registeredAt;
    }
    
        public String getCalssofvehicle() {
        return calssofvehicle;
    }

    public void setCalssofvehicle(String calssofvehicle) {
        this.calssofvehicle = calssofvehicle;
    }

    public float getEnginecapacity() {
        return enginecapacity;
    }

    public void setEnginecapacity(float enginecapacity) {
        this.enginecapacity = enginecapacity;
    }

    public String getSpecialnotes() {
        return specialnotes;
    }

    public void setSpecialnotes(String specialnotes) {
        this.specialnotes = specialnotes;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getYearofmaufacture() {
        return yearofmaufacture;
    }

    public void setYearofmaufacture(Date yearofmaufacture) {
        this.yearofmaufacture = yearofmaufacture;
    }
    
}
