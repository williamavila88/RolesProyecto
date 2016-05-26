/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByPercedula", query = "SELECT p FROM Persona p WHERE p.percedula = :percedula"),
    @NamedQuery(name = "Persona.findByPernombre", query = "SELECT p FROM Persona p WHERE p.pernombre = :pernombre"),
    @NamedQuery(name = "Persona.findByPerapellido", query = "SELECT p FROM Persona p WHERE p.perapellido = :perapellido"),
    @NamedQuery(name = "Persona.findByPertelefonofijo", query = "SELECT p FROM Persona p WHERE p.pertelefonofijo = :pertelefonofijo"),
    @NamedQuery(name = "Persona.findByPerfechadenacimiento", query = "SELECT p FROM Persona p WHERE p.perfechadenacimiento = :perfechadenacimiento"),
    @NamedQuery(name = "Persona.findByNumerolinea", query = "SELECT p FROM Persona p WHERE p.numerolinea = :numerolinea")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "percedula")
    private Integer percedula;
    @Size(max = 45)
    @Column(name = "pernombre")
    private String pernombre;
    @Size(max = 45)
    @Column(name = "perapellido")
    private String perapellido;
    @Size(max = 45)
    @Column(name = "pertelefonofijo")
    private String pertelefonofijo;
    @Size(max = 45)
    @Column(name = "perfechadenacimiento")
    private String perfechadenacimiento;
    @Size(max = 45)
    @Column(name = "numerolinea")
    private String numerolinea;

    public Persona() {
    }

    public Persona(Integer percedula) {
        this.percedula = percedula;
    }

    public Integer getPercedula() {
        return percedula;
    }

    public void setPercedula(Integer percedula) {
        this.percedula = percedula;
    }

    public String getPernombre() {
        return pernombre;
    }

    public void setPernombre(String pernombre) {
        this.pernombre = pernombre;
    }

    public String getPerapellido() {
        return perapellido;
    }

    public void setPerapellido(String perapellido) {
        this.perapellido = perapellido;
    }

    public String getPertelefonofijo() {
        return pertelefonofijo;
    }

    public void setPertelefonofijo(String pertelefonofijo) {
        this.pertelefonofijo = pertelefonofijo;
    }

    public String getPerfechadenacimiento() {
        return perfechadenacimiento;
    }

    public void setPerfechadenacimiento(String perfechadenacimiento) {
        this.perfechadenacimiento = perfechadenacimiento;
    }

    public String getNumerolinea() {
        return numerolinea;
    }

    public void setNumerolinea(String numerolinea) {
        this.numerolinea = numerolinea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (percedula != null ? percedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.percedula == null && other.percedula != null) || (this.percedula != null && !this.percedula.equals(other.percedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.entity.Persona[ percedula=" + percedula + " ]";
    }
    
}
