/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "taxitenencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taxitenencia.findAll", query = "SELECT t FROM Taxitenencia t"),
    @NamedQuery(name = "Taxitenencia.findByNumChasis", query = "SELECT t FROM Taxitenencia t WHERE t.numChasis = :numChasis"),
    @NamedQuery(name = "Taxitenencia.findByEstadoFisico", query = "SELECT t FROM Taxitenencia t WHERE t.estadoFisico = :estadoFisico")})
public class Taxitenencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numChasis")
    private Long numChasis;
    @Size(max = 13)
    @Column(name = "estadoFisico")
    private String estadoFisico;
    @JoinColumn(name = "numChasis", referencedColumnName = "numChasis", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Taxis taxis;
    @OneToMany(mappedBy = "numChasis")
    private List<Mantenimiento> mantenimientoList;

    public Taxitenencia() {
    }

    public Taxitenencia(Long numChasis) {
        this.numChasis = numChasis;
    }

    public Long getNumChasis() {
        return numChasis;
    }

    public void setNumChasis(Long numChasis) {
        this.numChasis = numChasis;
    }

    public String getEstadoFisico() {
        return estadoFisico;
    }

    public void setEstadoFisico(String estadoFisico) {
        this.estadoFisico = estadoFisico;
    }

    public Taxis getTaxis() {
        return taxis;
    }

    public void setTaxis(Taxis taxis) {
        this.taxis = taxis;
    }

    @XmlTransient
    public List<Mantenimiento> getMantenimientoList() {
        return mantenimientoList;
    }

    public void setMantenimientoList(List<Mantenimiento> mantenimientoList) {
        this.mantenimientoList = mantenimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numChasis != null ? numChasis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taxitenencia)) {
            return false;
        }
        Taxitenencia other = (Taxitenencia) object;
        if ((this.numChasis == null && other.numChasis != null) || (this.numChasis != null && !this.numChasis.equals(other.numChasis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.entity.Taxitenencia[ numChasis=" + numChasis + " ]";
    }
    
}
