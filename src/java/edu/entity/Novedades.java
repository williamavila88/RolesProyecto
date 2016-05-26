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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "novedades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Novedades.findAll", query = "SELECT n FROM Novedades n"),
    @NamedQuery(name = "Novedades.findByIdNovedades", query = "SELECT n FROM Novedades n WHERE n.idNovedades = :idNovedades"),
    @NamedQuery(name = "Novedades.findByFecha", query = "SELECT n FROM Novedades n WHERE n.fecha = :fecha")})
public class Novedades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNovedades")
    private Integer idNovedades;
    @Lob
    @Size(max = 65535)
    @Column(name = "Asunto")
    private String asunto;
    @Size(max = 25)
    @Column(name = "fecha")
    private String fecha;
    @JoinColumn(name = "idUsuarios", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idUsuarios;

    public Novedades() {
    }

    public Novedades(Integer idNovedades) {
        this.idNovedades = idNovedades;
    }

    public Integer getIdNovedades() {
        return idNovedades;
    }

    public void setIdNovedades(Integer idNovedades) {
        this.idNovedades = idNovedades;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Usuarios getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Usuarios idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNovedades != null ? idNovedades.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Novedades)) {
            return false;
        }
        Novedades other = (Novedades) object;
        if ((this.idNovedades == null && other.idNovedades != null) || (this.idNovedades != null && !this.idNovedades.equals(other.idNovedades))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.entity.Novedades[ idNovedades=" + idNovedades + " ]";
    }
    
}
