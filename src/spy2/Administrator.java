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
@Table(name = "administrator", catalog = "ease", schema = "")
@NamedQueries({
    @NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a"),
    @NamedQuery(name = "Administrator.findByIdAdministrator", query = "SELECT a FROM Administrator a WHERE a.idAdministrator = :idAdministrator"),
    @NamedQuery(name = "Administrator.findByPassword", query = "SELECT a FROM Administrator a WHERE a.password = :password")})
public class Administrator implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idAdministrator")
    private Integer idAdministrator;
    @Column(name = "password")
    private String password;

    public Administrator() {
    }

    public Administrator(Integer idAdministrator) {
        this.idAdministrator = idAdministrator;
    }

    public Integer getIdAdministrator() {
        return idAdministrator;
    }

    public void setIdAdministrator(Integer idAdministrator) {
        Integer oldIdAdministrator = this.idAdministrator;
        this.idAdministrator = idAdministrator;
        changeSupport.firePropertyChange("idAdministrator", oldIdAdministrator, idAdministrator);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", oldPassword, password);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdministrator != null ? idAdministrator.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrator)) {
            return false;
        }
        Administrator other = (Administrator) object;
        if ((this.idAdministrator == null && other.idAdministrator != null) || (this.idAdministrator != null && !this.idAdministrator.equals(other.idAdministrator))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "spy2.Administrator[ idAdministrator=" + idAdministrator + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
