package lk.gov.health.vms.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 *
 * @author buddh
 */
@Entity
public class Institution implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @Lob
    private String address;
    private String type;

    @ManyToOne
    private Institution parent;

//------------newly added attributies---------------------------------------------
    private Long institutioncontactnumber;

    //---------director deatils-------------------------------------------------------
    private String directorname;
    private Long phonenumber;
    private String directoremail;
    //------------vehicle handler  details--------------------------------------------
    private String vehicleofficername;
    private Long vehicleofficercontact;
    private String vehicleofficeremail;
    private String vehicleofficerposition;


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
        if (!(object instanceof Institution)) {
            return false;
        }
        Institution other = (Institution) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lk.gov.health.vmis.entities.Institution[ id=" + id + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Institution getParent() {
        return parent;
    }

    public void setParent(Institution parent) {
        this.parent = parent;
    }
    
        public Long getInstitutioncontactnumber() {
        return institutioncontactnumber;
    }

    public void setInstitutioncontactnumber(Long institutioncontactnumber) {
        this.institutioncontactnumber = institutioncontactnumber;
    }

    public String getDirectorname() {
        return directorname;
    }

    public void setDirectorname(String directorname) {
        this.directorname = directorname;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getDirectoremail() {
        return directoremail;
    }

    public void setDirectoremail(String directoremail) {
        this.directoremail = directoremail;
    }

    public String getVehicleofficername() {
        return vehicleofficername;
    }

    public void setVehicleofficername(String vehicleofficername) {
        this.vehicleofficername = vehicleofficername;
    }

    public Long getVehicleofficercontact() {
        return vehicleofficercontact;
    }

    public void setVehicleofficercontact(Long vehicleofficercontact) {
        this.vehicleofficercontact = vehicleofficercontact;
    }

    public String getVehicleofficeremail() {
        return vehicleofficeremail;
    }

    public void setVehicleofficeremail(String vehicleofficeremail) {
        this.vehicleofficeremail = vehicleofficeremail;
    }

    public String getVehicleofficerposition() {
        return vehicleofficerposition;
    }

    public void setVehicleofficerposition(String vehicleofficerposition) {
        this.vehicleofficerposition = vehicleofficerposition;
    }


}
