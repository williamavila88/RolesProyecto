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
@Table(name = "juntadirectiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juntadirectiva.findAll", query = "SELECT j FROM Juntadirectiva j"),
    @NamedQuery(name = "Juntadirectiva.findByIdjuntaDirectiva", query = "SELECT j FROM Juntadirectiva j WHERE j.idjuntaDirectiva = :idjuntaDirectiva"),
    @NamedQuery(name = "Juntadirectiva.findByCargo", query = "SELECT j FROM Juntadirectiva j WHERE j.cargo = :cargo")})
public class Juntadirectiva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idjuntaDirectiva")
    private Integer idjuntaDirectiva;
    @Size(max = 12)
    @Column(name = "cargo")
    private String cargo;
    @OneToMany(mappedBy = "idDirectiva")
    private List<Votaciones> votacionesList;
    @JoinColumn(name = "idjuntaDirectiva", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuarios usuarios;

    public Juntadirectiva() {
    }

    public Juntadirectiva(Integer idjuntaDirectiva) {
        this.idjuntaDirectiva = idjuntaDirectiva;
    }

    public Integer getIdjuntaDirectiva() {
        return idjuntaDirectiva;
    }

    public void setIdjuntaDirectiva(Integer idjuntaDirectiva) {
        this.idjuntaDirectiva = idjuntaDirectiva;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @XmlTransient
    public List<Votaciones> getVotacionesList() {
        return votacionesList;
    }

    public void setVotacionesList(List<Votaciones> votacionesList) {
        this.votacionesList = votacionesList;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idjuntaDirectiva != null ? idjuntaDirectiva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juntadirectiva)) {
            return false;
        }
        Juntadirectiva other = (Juntadirectiva) object;
        if ((this.idjuntaDirectiva == null && other.idjuntaDirectiva != null) || (this.idjuntaDirectiva != null && !this.idjuntaDirectiva.equals(other.idjuntaDirectiva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.entity.Juntadirectiva[ idjuntaDirectiva=" + idjuntaDirectiva + " ]";
    }
    
}
