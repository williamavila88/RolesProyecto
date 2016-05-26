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
import javax.persistence.JoinColumn;
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
@Table(name = "gerente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gerente.findAll", query = "SELECT g FROM Gerente g"),
    @NamedQuery(name = "Gerente.findByIdGerente", query = "SELECT g FROM Gerente g WHERE g.idGerente = :idGerente"),
    @NamedQuery(name = "Gerente.findBySalario", query = "SELECT g FROM Gerente g WHERE g.salario = :salario")})
public class Gerente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idGerente")
    private Integer idGerente;
    @Size(max = 25)
    @Column(name = "Salario")
    private String salario;
    @JoinColumn(name = "idGerente", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuarios usuarios;

    public Gerente() {
    }

    public Gerente(Integer idGerente) {
        this.idGerente = idGerente;
    }

    public Integer getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(Integer idGerente) {
        this.idGerente = idGerente;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
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
        hash += (idGerente != null ? idGerente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gerente)) {
            return false;
        }
        Gerente other = (Gerente) object;
        if ((this.idGerente == null && other.idGerente != null) || (this.idGerente != null && !this.idGerente.equals(other.idGerente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.entity.Gerente[ idGerente=" + idGerente + " ]";
    }
    
}
