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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author renuka Theminda
 */
@Entity
public class FuelTransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Institution intitite;
   private Double requestQuantity;
    private Double issuedQuantity;
    private Double odoMeterReading;
    @ManyToOne
    private Vehicle vehicle;
    @ManyToOne
    private Institution fromInstitution;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date requestAt;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date requestedDate;
    @ManyToOne
    private Driver driver;
    @Lob
    private String comments;
     private String requestReferenceNumber;// bookrefernce number
    private String issueReferenceNumber;//Bill number
    
    @ManyToOne
    private FuelStation fuelstation;
   
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
        if (!(object instanceof FuelTransaction)) {
            return false;
        }
        FuelTransaction other = (FuelTransaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lk.gov.health.vmis.entities.FuelOrder[ id=" + id + " ]";
    }

    public Institution getIntitite() {
        return intitite;
    }

    public void setIntitite(Institution intitite) {
        this.intitite = intitite;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Institution getFromInstitution() {
        return fromInstitution;
    }

    public void setFromInstitution(Institution fromInstitution) {
        this.fromInstitution = fromInstitution;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Double getRequestQuantity() {
        return requestQuantity;
    }

    public void setRequestQuantity(Double requestQuantity) {
        this.requestQuantity = requestQuantity;
    }

    public Double getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(Double issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }

    public Double getOdoMeterReading() {
        return odoMeterReading;
    }

    public void setOdoMeterReading(Double odoMeterReading) {
        this.odoMeterReading = odoMeterReading;
    }

    public Date getRequestAt() {
        return requestAt;
    }

    public void setRequestAt(Date requestAt) {
        this.requestAt = requestAt;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public String getRequestReferenceNumber() {
        return requestReferenceNumber;
    }

    public void setRequestReferenceNumber(String requestReferenceNumber) {
        this.requestReferenceNumber = requestReferenceNumber;
    }

    public String getIssueReferenceNumber() {
        return issueReferenceNumber;
    }

    public void setIssueReferenceNumber(String issueReferenceNumber) {
        this.issueReferenceNumber = issueReferenceNumber;
    }

    public FuelStation getFuelstation() {
        return fuelstation;
    }

    public void setFuelstation(FuelStation fuelstation) {
        this.fuelstation = fuelstation;
    }
    
}
