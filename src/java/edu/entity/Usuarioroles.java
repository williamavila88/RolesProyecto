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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "usuarioroles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarioroles.findAll", query = "SELECT u FROM Usuarioroles u"),
    @NamedQuery(name = "Usuarioroles.findByIdUsuarioRoles", query = "SELECT u FROM Usuarioroles u WHERE u.idUsuarioRoles = :idUsuarioRoles")})
public class Usuarioroles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuarioRoles")
    private Integer idUsuarioRoles;
    @JoinColumn(name = "roles", referencedColumnName = "idRol")
    @ManyToOne
    private Rol roles;
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idUsuario;

    public Usuarioroles() {
    }

    public Usuarioroles(Integer idUsuarioRoles) {
        this.idUsuarioRoles = idUsuarioRoles;
    }

    public Integer getIdUsuarioRoles() {
        return idUsuarioRoles;
    }

    public void setIdUsuarioRoles(Integer idUsuarioRoles) {
        this.idUsuarioRoles = idUsuarioRoles;
    }

    public Rol getRoles() {
        return roles;
    }

    public void setRoles(Rol roles) {
        this.roles = roles;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioRoles != null ? idUsuarioRoles.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarioroles)) {
            return false;
        }
        Usuarioroles other = (Usuarioroles) object;
        if ((this.idUsuarioRoles == null && other.idUsuarioRoles != null) || (this.idUsuarioRoles != null && !this.idUsuarioRoles.equals(other.idUsuarioRoles))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.entity.Usuarioroles[ idUsuarioRoles=" + idUsuarioRoles + " ]";
    }
    
}
