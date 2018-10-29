/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spy2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Rowan
 */
@Entity
@Table(name = "student", catalog = "ease", schema = "")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByIdStudent", query = "SELECT s FROM Student s WHERE s.idStudent = :idStudent"),
    @NamedQuery(name = "Student.findByFirstName", query = "SELECT s FROM Student s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Student.findByLastName", query = "SELECT s FROM Student s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "Student.findByDob", query = "SELECT s FROM Student s WHERE s.dob = :dob"),
    @NamedQuery(name = "Student.findByPhoneNumber", query = "SELECT s FROM Student s WHERE s.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Student.findByZip", query = "SELECT s FROM Student s WHERE s.zip = :zip"),
    @NamedQuery(name = "Student.findByEmail", query = "SELECT s FROM Student s WHERE s.email = :email"),
    @NamedQuery(name = "Student.findByTitle", query = "SELECT s FROM Student s WHERE s.title = :title"),
    @NamedQuery(name = "Student.findByGender", query = "SELECT s FROM Student s WHERE s.gender = :gender"),
    @NamedQuery(name = "Student.findByNationality", query = "SELECT s FROM Student s WHERE s.nationality = :nationality"),
    @NamedQuery(name = "Student.findByIDnum", query = "SELECT s FROM Student s WHERE s.iDnum = :iDnum"),
    @NamedQuery(name = "Student.findByRace", query = "SELECT s FROM Student s WHERE s.race = :race"),
    @NamedQuery(name = "Student.findByCellNum", query = "SELECT s FROM Student s WHERE s.cellNum = :cellNum"),
    @NamedQuery(name = "Student.findByResAddress", query = "SELECT s FROM Student s WHERE s.resAddress = :resAddress"),
    @NamedQuery(name = "Student.findByCourse", query = "SELECT s FROM Student s WHERE s.course = :course"),
    @NamedQuery(name = "Student.findByHomeLang", query = "SELECT s FROM Student s WHERE s.homeLang = :homeLang")})
public class Student implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idStudent")
    private String idStudent;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "phoneNumber")
    private Integer phoneNumber;
    @Column(name = "zip")
    private Integer zip;
    @Column(name = "email")
    private String email;
    @Column(name = "title")
    private String title;
    @Column(name = "gender")
    private String gender;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "IDnum")
    private Integer iDnum;
    @Column(name = "race")
    private String race;
    @Column(name = "cellNum")
    private Integer cellNum;
    @Column(name = "resAddress")
    private String resAddress;
    @Column(name = "course")
    private String course;
    @Column(name = "homeLang")
    private String homeLang;

    public Student() {
    }

    public Student(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        String oldIdStudent = this.idStudent;
        this.idStudent = idStudent;
        changeSupport.firePropertyChange("idStudent", oldIdStudent, idStudent);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        changeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        changeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        Date oldDob = this.dob;
        this.dob = dob;
        changeSupport.firePropertyChange("dob", oldDob, dob);
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        Integer oldPhoneNumber = this.phoneNumber;
        this.phoneNumber = phoneNumber;
        changeSupport.firePropertyChange("phoneNumber", oldPhoneNumber, phoneNumber);
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        Integer oldZip = this.zip;
        this.zip = zip;
        changeSupport.firePropertyChange("zip", oldZip, zip);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        changeSupport.firePropertyChange("title", oldTitle, title);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        String oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        String oldNationality = this.nationality;
        this.nationality = nationality;
        changeSupport.firePropertyChange("nationality", oldNationality, nationality);
    }

    public Integer getIDnum() {
        return iDnum;
    }

    public void setIDnum(Integer iDnum) {
        Integer oldIDnum = this.iDnum;
        this.iDnum = iDnum;
        changeSupport.firePropertyChange("IDnum", oldIDnum, iDnum);
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        String oldRace = this.race;
        this.race = race;
        changeSupport.firePropertyChange("race", oldRace, race);
    }

    public Integer getCellNum() {
        return cellNum;
    }

    public void setCellNum(Integer cellNum) {
        Integer oldCellNum = this.cellNum;
        this.cellNum = cellNum;
        changeSupport.firePropertyChange("cellNum", oldCellNum, cellNum);
    }

    public String getResAddress() {
        return resAddress;
    }

    public void setResAddress(String resAddress) {
        String oldResAddress = this.resAddress;
        this.resAddress = resAddress;
        changeSupport.firePropertyChange("resAddress", oldResAddress, resAddress);
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        String oldCourse = this.course;
        this.course = course;
        changeSupport.firePropertyChange("course", oldCourse, course);
    }

    public String getHomeLang() {
        return homeLang;
    }

    public void setHomeLang(String homeLang) {
        String oldHomeLang = this.homeLang;
        this.homeLang = homeLang;
        changeSupport.firePropertyChange("homeLang", oldHomeLang, homeLang);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStudent != null ? idStudent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.idStudent == null && other.idStudent != null) || (this.idStudent != null && !this.idStudent.equals(other.idStudent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "spy2.Student[ idStudent=" + idStudent + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
