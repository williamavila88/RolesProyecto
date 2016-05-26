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
@Table(name = "pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p"),
    @NamedQuery(name = "Pagos.findByNumRecibo", query = "SELECT p FROM Pagos p WHERE p.numRecibo = :numRecibo"),
    @NamedQuery(name = "Pagos.findByFecha", query = "SELECT p FROM Pagos p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Pagos.findByNunCuotasCanceladas", query = "SELECT p FROM Pagos p WHERE p.nunCuotasCanceladas = :nunCuotasCanceladas"),
    @NamedQuery(name = "Pagos.findByValor", query = "SELECT p FROM Pagos p WHERE p.valor = :valor"),
    @NamedQuery(name = "Pagos.findByTotal", query = "SELECT p FROM Pagos p WHERE p.total = :total"),
    @NamedQuery(name = "Pagos.findByEstado", query = "SELECT p FROM Pagos p WHERE p.estado = :estado")})
public class Pagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numRecibo")
    private Integer numRecibo;
    @Size(max = 25)
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "nunCuotasCanceladas")
    private Integer nunCuotasCanceladas;
    @Column(name = "valor")
    private Integer valor;
    @Column(name = "total")
    private Integer total;
    @Size(max = 8)
    @Column(name = "Estado")
    private String estado;

    public Pagos() {
    }

    public Pagos(Integer numRecibo) {
        this.numRecibo = numRecibo;
    }

    public Integer getNumRecibo() {
        return numRecibo;
    }

    public void setNumRecibo(Integer numRecibo) {
        this.numRecibo = numRecibo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getNunCuotasCanceladas() {
        return nunCuotasCanceladas;
    }

    public void setNunCuotasCanceladas(Integer nunCuotasCanceladas) {
        this.nunCuotasCanceladas = nunCuotasCanceladas;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numRecibo != null ? numRecibo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.numRecibo == null && other.numRecibo != null) || (this.numRecibo != null && !this.numRecibo.equals(other.numRecibo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.entity.Pagos[ numRecibo=" + numRecibo + " ]";
    }
    
}
