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
@Table(name = "socios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Socios.findAll", query = "SELECT s FROM Socios s"),
    @NamedQuery(name = "Socios.findByIdSocios", query = "SELECT s FROM Socios s WHERE s.idSocios = :idSocios"),
    @NamedQuery(name = "Socios.findByCodigo", query = "SELECT s FROM Socios s WHERE s.codigo = :codigo")})
public class Socios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSocios")
    private Integer idSocios;
    @Column(name = "codigo")
    private Integer codigo;
    @JoinColumn(name = "idSocios", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuarios usuarios;

    public Socios() {
    }

    public Socios(Integer idSocios) {
        this.idSocios = idSocios;
    }

    public Integer getIdSocios() {
        return idSocios;
    }

    public void setIdSocios(Integer idSocios) {
        this.idSocios = idSocios;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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
        hash += (idSocios != null ? idSocios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Socios)) {
            return false;
        }
        Socios other = (Socios) object;
        if ((this.idSocios == null && other.idSocios != null) || (this.idSocios != null && !this.idSocios.equals(other.idSocios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.entity.Socios[ idSocios=" + idSocios + " ]";
    }
    
}
