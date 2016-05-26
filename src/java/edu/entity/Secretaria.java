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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "secretaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secretaria.findAll", query = "SELECT s FROM Secretaria s"),
    @NamedQuery(name = "Secretaria.findByIdSecretaria", query = "SELECT s FROM Secretaria s WHERE s.idSecretaria = :idSecretaria"),
    @NamedQuery(name = "Secretaria.findByCarne", query = "SELECT s FROM Secretaria s WHERE s.carne = :carne"),
    @NamedQuery(name = "Secretaria.findBySalario", query = "SELECT s FROM Secretaria s WHERE s.salario = :salario")})
public class Secretaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSecretaria")
    private Integer idSecretaria;
    @Column(name = "carne")
    private Integer carne;
    @Column(name = "salario")
    private Integer salario;
    @JoinColumn(name = "idSecretaria", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuarios usuarios;

    public Secretaria() {
    }

    public Secretaria(Integer idSecretaria) {
        this.idSecretaria = idSecretaria;
    }

    public Integer getIdSecretaria() {
        return idSecretaria;
    }

    public void setIdSecretaria(Integer idSecretaria) {
        this.idSecretaria = idSecretaria;
    }

    public Integer getCarne() {
        return carne;
    }

    public void setCarne(Integer carne) {
        this.carne = carne;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
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
        hash += (idSecretaria != null ? idSecretaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secretaria)) {
            return false;
        }
        Secretaria other = (Secretaria) object;
        if ((this.idSecretaria == null && other.idSecretaria != null) || (this.idSecretaria != null && !this.idSecretaria.equals(other.idSecretaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.entity.Secretaria[ idSecretaria=" + idSecretaria + " ]";
    }
    
}
