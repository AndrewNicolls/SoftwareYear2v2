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
@Table(name = "module", catalog = "ease", schema = "")
@NamedQueries({
    @NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m"),
    @NamedQuery(name = "Module.findByIdModule", query = "SELECT m FROM Module m WHERE m.idModule = :idModule"),
    @NamedQuery(name = "Module.findByName", query = "SELECT m FROM Module m WHERE m.name = :name"),
    @NamedQuery(name = "Module.findByCredits", query = "SELECT m FROM Module m WHERE m.credits = :credits"),
    @NamedQuery(name = "Module.findByFee", query = "SELECT m FROM Module m WHERE m.fee = :fee"),
    @NamedQuery(name = "Module.findByTime", query = "SELECT m FROM Module m WHERE m.time = :time"),
    @NamedQuery(name = "Module.findByDays", query = "SELECT m FROM Module m WHERE m.days = :days"),
    @NamedQuery(name = "Module.findByRoom", query = "SELECT m FROM Module m WHERE m.room = :room"),
    @NamedQuery(name = "Module.findByLecturer", query = "SELECT m FROM Module m WHERE m.lecturer = :lecturer"),
    @NamedQuery(name = "Module.findBySemester", query = "SELECT m FROM Module m WHERE m.semester = :semester")})
public class Module implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idModule")
    private Integer idModule;
    @Column(name = "name")
    private String name;
    @Column(name = "credits")
    private Integer credits;
    @Column(name = "fee")
    private Short fee;
    @Column(name = "time")
    private String time;
    @Column(name = "days")
    private String days;
    @Column(name = "room")
    private String room;
    @Column(name = "lecturer")
    private String lecturer;
    @Column(name = "semester")
    private String semester;

    public Module() {
    }

    public Module(Integer idModule) {
        this.idModule = idModule;
    }

    public Integer getIdModule() {
        return idModule;
    }

    public void setIdModule(Integer idModule) {
        Integer oldIdModule = this.idModule;
        this.idModule = idModule;
        changeSupport.firePropertyChange("idModule", oldIdModule, idModule);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        Integer oldCredits = this.credits;
        this.credits = credits;
        changeSupport.firePropertyChange("credits", oldCredits, credits);
    }

    public Short getFee() {
        return fee;
    }

    public void setFee(Short fee) {
        Short oldFee = this.fee;
        this.fee = fee;
        changeSupport.firePropertyChange("fee", oldFee, fee);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        String oldTime = this.time;
        this.time = time;
        changeSupport.firePropertyChange("time", oldTime, time);
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        String oldDays = this.days;
        this.days = days;
        changeSupport.firePropertyChange("days", oldDays, days);
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        String oldRoom = this.room;
        this.room = room;
        changeSupport.firePropertyChange("room", oldRoom, room);
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        String oldLecturer = this.lecturer;
        this.lecturer = lecturer;
        changeSupport.firePropertyChange("lecturer", oldLecturer, lecturer);
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        String oldSemester = this.semester;
        this.semester = semester;
        changeSupport.firePropertyChange("semester", oldSemester, semester);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModule != null ? idModule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.idModule == null && other.idModule != null) || (this.idModule != null && !this.idModule.equals(other.idModule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "spy2.Module[ idModule=" + idModule + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
