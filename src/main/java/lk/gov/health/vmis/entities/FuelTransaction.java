/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.gov.health.vmis.entities;

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
    Institution intitite;
   private Double requestQuantity;
    private Double issuedQuantity;
    private Double odoMeterReading;
    @ManyToOne
    Vehicle vehicle;
    @ManyToOne
    Institution fromInstitution;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date requestAt;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date requestedDate;
    @ManyToOne
    Driver driver;
    @Lob
    String comments;
     private String requestReferenceNumber;// bookrefernce number
    private String issueReferenceNumber;//Bill number
    

    

    
    
    
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
    
}
