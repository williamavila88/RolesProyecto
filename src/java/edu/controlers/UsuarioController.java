/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.controlers;

import edu.entity.Usuarioroles;
import edu.entity.Usuarios;
import edu.facade.RolFacade;
import edu.facade.UsuariorolesFacade;
import edu.facade.UsuariosFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author usuario
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

private int estados=0;    
private int id;
private String contrasena;
private String rol;
private Usuarios usuLogin;
private List<Usuarioroles> roles;

    /**
     * Creates a new instance of UsuarioController
     */
    @Inject
    UsuariosFacade uf;
 


    public UsuarioController() {
    }
      public String iniciarSesion() {

        FacesContext faces = FacesContext.getCurrentInstance();
        ExternalContext externalContext = faces.getExternalContext();
        Map<String, String> params = (Map<String, String>) externalContext.getRequestParameterMap();
        this.id = Integer.parseInt((String) params.get("id"));
        this.contrasena = (String) params.get("contrasena");
        String pag = "null";
        Usuarios misUsu = this.uf.login(this.id, this.contrasena);
        if (misUsu.getNombre().equals("vacio")) {
       
            

        } else {

            HttpServletRequest miSesion = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                    .getRequest();
            miSesion.getSession().setAttribute("usuario", misUsu);
            pag = "rol";
        }
        return pag;
    }
      
      
        public List<Usuarioroles> getRoles() {    
        HttpServletRequest miSesion = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        this.usuLogin = (Usuarios) miSesion.getSession().getAttribute("usuario");
        return usuLogin.getUsuariorolesList();
    }

         public void redireccionar() throws IOException {

        if (this.rol.equals("Administrador")) {

            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/sipact2/faces/administrador/Administrador.xhtml");

        }
        if (this.rol.equals("Gerente")) {

            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/Roles/faces/gerente.xhtml");

        }
        if (this.rol.equals("Secretaria")) {

            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/Roles/faces/secretaria.xhtml");

        }
        if (this.rol.equals("Junta Directiva")) {

            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/Roles/faces/directa.xhtml");

        }
        if (this.rol.equals("Socio")) {

            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/Roles/faces/asamblea.xhtml");

        }
        if (this.rol.equals("Socio Adjudicado")) {

            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/Roles/faces/adjudicado.xhtml");

        }

    }
         
         
     public void miraSession() throws IOException {
        HttpServletRequest miSesion = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        this.usuLogin = (Usuarios) miSesion.getSession().getAttribute("usuario");
        if (!(usuLogin != null)) {

            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            FacesContext.getCurrentInstance().
                    responseComplete();

            response.sendRedirect("/sipact");
        }
    }
         public void miraSession(String rol) throws IOException {

        HttpServletRequest miSesion = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        this.usuLogin = (Usuarios) miSesion.getSession().getAttribute("usuario");
        String rolSesion= (String) miSesion.getSession().getAttribute("rol");
        this.estados = 0;
        if (rol.equals("Administrador")) {
            if (!(usuLogin != null)) {
                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                FacesContext.getCurrentInstance().
                        responseComplete();
                response.sendRedirect("/");
            }else if(!rolSesion.equals("Gerente")){
                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                FacesContext.getCurrentInstance().
                        responseComplete();
                response.sendRedirect("/NowVet");
            }
        } else if (rol.equals("cliente")) {
            if (!(usuLogin != null)) {
                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                FacesContext.getCurrentInstance().
                        responseComplete();
                response.sendRedirect("/NowVet");
            }else if(!rolSesion.equals("Cliente")){
                HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                FacesContext.getCurrentInstance().
                        responseComplete();
                response.sendRedirect("/NowVet");
            }
        }
        else if(rol.isEmpty()){
          HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                FacesContext.getCurrentInstance().
                        responseComplete();
                response.sendRedirect("/Roles");
        }

    }    
        
        
    public int getEstados() {
        return estados;
    }

    public void setEstados(int estados) {
        this.estados = estados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public UsuariosFacade getUf() {
        return uf;
    }

    public void setUf(UsuariosFacade uf) {
        this.uf = uf;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuarios getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(Usuarios usuLogin) {
        this.usuLogin = usuLogin;
    }

 

    public void setRoles(List<Usuarioroles> roles) {
        this.roles = roles;
    }

  
      
}
