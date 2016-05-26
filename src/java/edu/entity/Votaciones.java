/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "votaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Votaciones.findAll", query = "SELECT v FROM Votaciones v"),
    @NamedQuery(name = "Votaciones.findByIdVotaciones", query = "SELECT v FROM Votaciones v WHERE v.idVotaciones = :idVotaciones"),
    @NamedQuery(name = "Votaciones.findByValoracion", query = "SELECT v FROM Votaciones v WHERE v.valoracion = :valoracion"),
    @NamedQuery(name = "Votaciones.findByFecha", query = "SELECT v FROM Votaciones v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Votaciones.findByEstado", query = "SELECT v FROM Votaciones v WHERE v.estado = :estado")})
public class Votaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVotaciones")
    private Integer idVotaciones;
    @Size(max = 3)
    @Column(name = "valoracion")
    private String valoracion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 11)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idDirectiva", referencedColumnName = "idjuntaDirectiva")
    @ManyToOne
    private Juntadirectiva idDirectiva;
    @JoinColumn(name = "idEventos", referencedColumnName = "idEventos")
    @ManyToOne(optional = false)
    private Eventos idEventos;

    public Votaciones() {
    }

    public Votaciones(Integer idVotaciones) {
        this.idVotaciones = idVotaciones;
    }

    public Integer getIdVotaciones() {
        return idVotaciones;
    }

    public void setIdVotaciones(Integer idVotaciones) {
        this.idVotaciones = idVotaciones;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Juntadirectiva getIdDirectiva() {
        return idDirectiva;
    }

    public void setIdDirectiva(Juntadirectiva idDirectiva) {
        this.idDirectiva = idDirectiva;
    }

    public Eventos getIdEventos() {
        return idEventos;
    }

    public void setIdEventos(Eventos idEventos) {
        this.idEventos = idEventos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVotaciones != null ? idVotaciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Votaciones)) {
            return false;
        }
        Votaciones other = (Votaciones) object;
        if ((this.idVotaciones == null && other.idVotaciones != null) || (this.idVotaciones != null && !this.idVotaciones.equals(other.idVotaciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.entity.Votaciones[ idVotaciones=" + idVotaciones + " ]";
    }
    
}
