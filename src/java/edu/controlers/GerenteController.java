/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.controlers;

import edu.entity.Gerente;
import edu.entity.Rol;
import edu.entity.Usuarioroles;
import edu.entity.Usuarios;
import edu.facade.GerenteFacade;
import edu.facade.UsuariorolesFacade;
import edu.facade.UsuariosFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author usuario
 */
@Named(value = "gerenteController")
@SessionScoped
public class GerenteController implements Serializable {

    @Inject
    UsuariorolesFacade usuariorolFacade;
    @Inject
    GerenteFacade gerentef;
    @Inject
    UsuariosFacade usuariosfacade;        

   Usuarios usuarios=new Usuarios();
   Usuarios user=new Usuarios();
   Gerente gerente=new Gerente();
    
    public List<Usuarios> listarSocios(){
    return this.usuariosfacade.traerSocios();
    
    }
    public List<Usuarios> listarGerentes(){
    return this.usuariosfacade.findAll();
    
    }
        public String cambiargerente() {
        Rol rol = new Rol();
        Usuarioroles usuarioRol = new Usuarioroles();
//Eliminar
        rol.setIdRol(2);
        rol.setRol("Gerente");
        usuarioRol.setIdUsuario(user);
        usuarioRol.setRoles(rol);
        this.usuariorolFacade.remove(usuarioRol);
        this.gerentef.remove(gerente);

//Crear.
        rol.setIdRol(2);
        rol.setRol("Gerente");

        usuarioRol.setRoles(rol);
        usuarioRol.setIdUsuario(this.usuarios);
        this.usuariorolFacade.create(usuarioRol);
        this.gerente.setIdGerente(this.usuarios.getId());
        this.gerente.setSalario(this.gerente.getSalario());

        this.gerentef.create(gerente);

        return "cambiarGerente";
    }

    public String enviarGerente() {

        return "cambiarGerente";
    }

    public GerenteController() {
    }

    public UsuariorolesFacade getUsuariorolFacade() {
        return usuariorolFacade;
    }

    public void setUsuariorolFacade(UsuariorolesFacade usuariorolFacade) {
        this.usuariorolFacade = usuariorolFacade;
    }

    public GerenteFacade getGerentef() {
        return gerentef;
    }

    public void setGerentef(GerenteFacade gerentef) {
        this.gerentef = gerentef;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
    
}
