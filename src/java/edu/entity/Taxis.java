/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "taxis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taxis.findAll", query = "SELECT t FROM Taxis t"),
    @NamedQuery(name = "Taxis.findByNumChasis", query = "SELECT t FROM Taxis t WHERE t.numChasis = :numChasis"),
    @NamedQuery(name = "Taxis.findByPlaca", query = "SELECT t FROM Taxis t WHERE t.placa = :placa"),
    @NamedQuery(name = "Taxis.findByMarca", query = "SELECT t FROM Taxis t WHERE t.marca = :marca"),
    @NamedQuery(name = "Taxis.findByModelo", query = "SELECT t FROM Taxis t WHERE t.modelo = :modelo"),
    @NamedQuery(name = "Taxis.findByValor", query = "SELECT t FROM Taxis t WHERE t.valor = :valor"),
    @NamedQuery(name = "Taxis.findByEstado", query = "SELECT t FROM Taxis t WHERE t.estado = :estado")})
public class Taxis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numChasis")
    private Long numChasis;
    @Size(max = 6)
    @Column(name = "placa")
    private String placa;
    @Size(max = 25)
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private Integer modelo;
    @Column(name = "valor")
    private Integer valor;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "taxis")
    private Taxitenencia taxitenencia;

    public Taxis() {
    }

    public Taxis(Long numChasis) {
        this.numChasis = numChasis;
    }

    public Long getNumChasis() {
        return numChasis;
    }

    public void setNumChasis(Long numChasis) {
        this.numChasis = numChasis;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Taxitenencia getTaxitenencia() {
        return taxitenencia;
    }

    public void setTaxitenencia(Taxitenencia taxitenencia) {
        this.taxitenencia = taxitenencia;
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
        if (!(object instanceof Taxis)) {
            return false;
        }
        Taxis other = (Taxis) object;
        if ((this.numChasis == null && other.numChasis != null) || (this.numChasis != null && !this.numChasis.equals(other.numChasis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.entity.Taxis[ numChasis=" + numChasis + " ]";
    }
    
}
