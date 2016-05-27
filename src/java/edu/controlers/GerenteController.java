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
import javax.ejb.EJB;
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
    @EJB
    GerenteFacade gerentef;
    @Inject
    UsuariosFacade usuariosfacade;    
    
    Usuarios usuarios = new Usuarios();
    Usuarios user = new Usuarios();
    Gerente gerente = new Gerente();
    
    public List<Usuarios> listargerentes() {
        return this.usuariosfacade.traerGerenteList();
        
    }
    public List<Usuarios> traerSocios(){
        return this.usuariosfacade.traerSocios();
    }
    
    
    
    
    
    public String cambiargerente() {
        Rol rol = new Rol();
        Usuarioroles usuarioRol = new Usuarioroles();
        //Cambiar tablas Usuarioroles
        //Gerente eliminar rol  
        rol.setIdRol(5);
        rol.setRol("Socio");
        List<Usuarioroles> ur = this.usuariorolFacade.traerGerente(2,user.getId());
        for (int i = 0; i < ur.size(); i++) {
            Usuarioroles get = ur.get(i);
               this.usuariorolFacade.remove(get);
        }
     

        //Socio que sera el Gerente
        rol.setIdRol(2);
        rol.setRol("Gerente");
        List<Usuarioroles> soc=this.usuariorolFacade.traerSocioNewMAnager(this.usuarios.getId());
        
        for (int i = 0; i < soc.size(); i++) {
            Usuarioroles get = soc.get(i);
             get.setIdUsuario(usuarios);
        get.setRoles(rol);
        this.usuariorolFacade.create(get);
        }
        
       

//Remplazar gerente por Nuevo
        List<Gerente> g;
        g = this.usuariosfacade.getGerente();
        for (int i = 0; i < g.size(); i++) {
            Gerente get = g.get(i);
            
            get.setIdGerente(usuarios.getId());
            this.gerentef.edit(get);

            //Cambiar Roles en la vista              
            Usuarios ge = this.usuariosfacade.getVistaGerente();
            ge.setRol(5);
            this.usuariosfacade.edit(ge);
            Usuarios so = this.usuariosfacade.getVistaSocio(this.usuarios.getId());
            so.setId(2);
            this.usuariosfacade.edit(so);
        }
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
