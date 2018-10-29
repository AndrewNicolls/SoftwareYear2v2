/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spy2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Rowan
 */
@Entity
@Table(name = "sponsor", catalog = "ease", schema = "")
@NamedQueries({
    @NamedQuery(name = "Sponsor.findAll", query = "SELECT s FROM Sponsor s"),
    @NamedQuery(name = "Sponsor.findByIdSponsor", query = "SELECT s FROM Sponsor s WHERE s.idSponsor = :idSponsor"),
    @NamedQuery(name = "Sponsor.findByTitle", query = "SELECT s FROM Sponsor s WHERE s.title = :title"),
    @NamedQuery(name = "Sponsor.findByName", query = "SELECT s FROM Sponsor s WHERE s.name = :name"),
    @NamedQuery(name = "Sponsor.findBySurname", query = "SELECT s FROM Sponsor s WHERE s.surname = :surname"),
    @NamedQuery(name = "Sponsor.findByInitials", query = "SELECT s FROM Sponsor s WHERE s.initials = :initials"),
    @NamedQuery(name = "Sponsor.findByIDNumber", query = "SELECT s FROM Sponsor s WHERE s.iDNumber = :iDNumber"),
    @NamedQuery(name = "Sponsor.findByMaritalstatus", query = "SELECT s FROM Sponsor s WHERE s.maritalstatus = :maritalstatus"),
    @NamedQuery(name = "Sponsor.findByEmail", query = "SELECT s FROM Sponsor s WHERE s.email = :email"),
    @NamedQuery(name = "Sponsor.findByCellNum", query = "SELECT s FROM Sponsor s WHERE s.cellNum = :cellNum"),
    @NamedQuery(name = "Sponsor.findByHomeNum", query = "SELECT s FROM Sponsor s WHERE s.homeNum = :homeNum"),
    @NamedQuery(name = "Sponsor.findByResAddress", query = "SELECT s FROM Sponsor s WHERE s.resAddress = :resAddress"),
    @NamedQuery(name = "Sponsor.findByResZip", query = "SELECT s FROM Sponsor s WHERE s.resZip = :resZip"),
    @NamedQuery(name = "Sponsor.findByPostAddress", query = "SELECT s FROM Sponsor s WHERE s.postAddress = :postAddress"),
    @NamedQuery(name = "Sponsor.findByPostZip", query = "SELECT s FROM Sponsor s WHERE s.postZip = :postZip"),
    @NamedQuery(name = "Sponsor.findByIdStudent", query = "SELECT s FROM Sponsor s WHERE s.idStudent = :idStudent")})
public class Sponsor implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idSponsor")
    private Integer idSponsor;
    @Column(name = "Title")
    private String title;
    @Column(name = "Name")
    private String name;
    @Column(name = "Surname")
    private String surname;
    @Column(name = "Initials")
    private String initials;
    @Column(name = "ID Number")
    private String iDNumber;
    @Column(name = "Marital status")
    private String maritalstatus;
    @Column(name = "email")
    private String email;
    @Column(name = "cellNum")
    private String cellNum;
    @Column(name = "homeNum")
    private String homeNum;
    @Column(name = "resAddress")
    private String resAddress;
    @Column(name = "resZip")
    private String resZip;
    @Column(name = "postAddress")
    private String postAddress;
    @Column(name = "postZip")
    private String postZip;
    @Basic(optional = false)
    @Column(name = "idStudent")
    private String idStudent;

    public Sponsor() {
    }

    public Sponsor(Integer idSponsor) {
        this.idSponsor = idSponsor;
    }

    public Sponsor(Integer idSponsor, String idStudent) {
        this.idSponsor = idSponsor;
        this.idStudent = idStudent;
    }

    public Integer getIdSponsor() {
        return idSponsor;
    }

    public void setIdSponsor(Integer idSponsor) {
        Integer oldIdSponsor = this.idSponsor;
        this.idSponsor = idSponsor;
        changeSupport.firePropertyChange("idSponsor", oldIdSponsor, idSponsor);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        changeSupport.firePropertyChange("title", oldTitle, title);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        String oldSurname = this.surname;
        this.surname = surname;
        changeSupport.firePropertyChange("surname", oldSurname, surname);
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        String oldInitials = this.initials;
        this.initials = initials;
        changeSupport.firePropertyChange("initials", oldInitials, initials);
    }

    public String getIDNumber() {
        return iDNumber;
    }

    public void setIDNumber(String iDNumber) {
        String oldIDNumber = this.iDNumber;
        this.iDNumber = iDNumber;
        changeSupport.firePropertyChange("IDNumber", oldIDNumber, iDNumber);
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        String oldMaritalstatus = this.maritalstatus;
        this.maritalstatus = maritalstatus;
        changeSupport.firePropertyChange("maritalstatus", oldMaritalstatus, maritalstatus);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getCellNum() {
        return cellNum;
    }

    public void setCellNum(String cellNum) {
        String oldCellNum = this.cellNum;
        this.cellNum = cellNum;
        changeSupport.firePropertyChange("cellNum", oldCellNum, cellNum);
    }

    public String getHomeNum() {
        return homeNum;
    }

    public void setHomeNum(String homeNum) {
        String oldHomeNum = this.homeNum;
        this.homeNum = homeNum;
        changeSupport.firePropertyChange("homeNum", oldHomeNum, homeNum);
    }

    public String getResAddress() {
        return resAddress;
    }

    public void setResAddress(String resAddress) {
        String oldResAddress = this.resAddress;
        this.resAddress = resAddress;
        changeSupport.firePropertyChange("resAddress", oldResAddress, resAddress);
    }

    public String getResZip() {
        return resZip;
    }

    public void setResZip(String resZip) {
        String oldResZip = this.resZip;
        this.resZip = resZip;
        changeSupport.firePropertyChange("resZip", oldResZip, resZip);
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        String oldPostAddress = this.postAddress;
        this.postAddress = postAddress;
        changeSupport.firePropertyChange("postAddress", oldPostAddress, postAddress);
    }

    public String getPostZip() {
        return postZip;
    }

    public void setPostZip(String postZip) {
        String oldPostZip = this.postZip;
        this.postZip = postZip;
        changeSupport.firePropertyChange("postZip", oldPostZip, postZip);
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        String oldIdStudent = this.idStudent;
        this.idStudent = idStudent;
        changeSupport.firePropertyChange("idStudent", oldIdStudent, idStudent);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSponsor != null ? idSponsor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sponsor)) {
            return false;
        }
        Sponsor other = (Sponsor) object;
        if ((this.idSponsor == null && other.idSponsor != null) || (this.idSponsor != null && !this.idSponsor.equals(other.idSponsor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "spy2.Sponsor[ idSponsor=" + idSponsor + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
