/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dleon.dbprog.app.data.entities.jpa;

import com.dleon.dbprog.app.data.entities.Student;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentJPA.findAll", query = "SELECT s FROM StudentJPA s"),
    @NamedQuery(name = "StudentJPA.findById", query = "SELECT s FROM StudentJPA s WHERE s.id = :id"),
    @NamedQuery(name = "StudentJPA.findByStudentName", query = "SELECT s FROM StudentJPA s WHERE s.name = :name"),
    @NamedQuery(name = "StudentJPA.findByLastName", query = "SELECT s FROM StudentJPA s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "StudentJPA.findByBirthday", query = "SELECT s FROM StudentJPA s WHERE s.birthday = :birthday")})
public class StudentJPA implements Serializable, Student {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    public StudentJPA() {
    }

    public StudentJPA(Integer id) {
        this.id = id;
    }

    public StudentJPA(String name, String lastName, Date birthday) {
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String studentName) {
        this.name = studentName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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
        if (!(object instanceof StudentJPA)) {
            return false;
        }
        StudentJPA other = (StudentJPA) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dleon.dbprog.app.data.entities.jpa.StudentJPA[ id=" + id + " ]";
    }
    
}
