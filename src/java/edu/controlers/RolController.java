    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.controlers;

import edu.entity.Rol;
import edu.entity.Usuarios;
import edu.facade.RolFacade;
import edu.facade.UsuariosFacade;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Bebe
 */
@ManagedBean
@RequestScoped
public class RolController {
@Inject
RolFacade rolesFacade;
@EJB
UsuariosFacade usuF;

private int id;
private String nombre;


Rol roles1=new Rol();




public List<Rol> listarRoles(){
    
    return this.rolesFacade.findAll();
    
}

public String eliminarRol(Rol r){
    this.rolesFacade.remove(r);

return"listarRoles1";
}

public String crearRol(){
    Rol rol = new Rol();

        rol.setIdRol(id);
        rol.setRol(nombre);
        
        this.rolesFacade.create(rol);
        return"listarRoles1";
 
}
public String mostrarRol(){

return "editarRol";

}

public String editarRol(Rol r){
 this.rolesFacade.edit(r);
        return"editarRol";
}

public String actualizarRol(Rol rol) {

        FacesContext faces = FacesContext.getCurrentInstance();
        ExternalContext externalContext = faces.getExternalContext();
        Map<String, String> params = (Map<String, String>) externalContext.getRequestParameterMap();
        String formularioAct = (params.get("nombre"));
        rol.setRol(params.get(formularioAct + ":nombre"));
        rolesFacade.edit(rol);
       
        return "listarRoles";
    }
   
    public RolController() {
    }

    
    
    public RolFacade getRolesFacade() {
        return rolesFacade;
    }

    public void setRolesFacade(RolFacade rolesFacade) {
        this.rolesFacade = rolesFacade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rol getRoles1() {
        return roles1;
    }

    public void setRoles1(Rol roles1) {
        this.roles1 = roles1;
    }

    public UsuariosFacade getUsuF() {
        return usuF;
    }

    public void setUsuF(UsuariosFacade usuF) {
        this.usuF = usuF;
    }

 
    
}
