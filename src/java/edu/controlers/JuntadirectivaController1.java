/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.controlers;

import edu.entity.Juntadirectiva;
import edu.entity.Rol;
import edu.entity.Socios;
import edu.entity.Usuarioroles;
import edu.entity.Usuarios;
import edu.facade.JuntadirectivaFacade;
import edu.facade.RolFacade;
import edu.facade.SociosFacade;
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
@Named(value = "juntadirectivaController1")
@SessionScoped
public class JuntadirectivaController1 implements Serializable {

    @Inject
    JuntadirectivaFacade jDFacade;
    @Inject
    UsuariosFacade usuariosFacade;
    @Inject
    SociosFacade sociosFacade;
    @Inject
    RolFacade rolfacade;
    @Inject
    UsuariorolesFacade usuariorolFacade;
    
    private int idJuntaDirectiva;
    private String cargo;

    private String nombre;
    private String apellido;
    private String direccion;
    private String correo;
    private String fechaNacimiento;
    private String telefono;
    private String usuario;
    private String contrasena;
    
    Juntadirectiva juntaDirectiva = new Juntadirectiva();
   
  
    Usuarios user = new Usuarios();
    private Usuarios userNew = new Usuarios();
    
    Socios socio=new Socios();
    Rol rol=new Rol();
    Rol rolEliminar=new Rol();
    Usuarioroles usuarioRol=new Usuarioroles();
    

   
   public List<Usuarios> listarJuntaDirectiva(){
   
       return this.usuariosFacade.findAll();
   }
   
   public String enviarJuntaDirectiva(){
 
      
       
       
       
   return "cambiarMiembroJD1";
   }
   
  
   
    public String cambiarMiembroJD(Usuarios u){
        //Eliminar
        
        this.rol.setRol("Junta Directiva");
        this.rol.setIdRol(5);
        this.jDFacade.remove(juntaDirectiva);
        this.usuarioRol.setRoles(rol);
        this.usuarioRol.setIdUsuario(user);
        this.usuariorolFacade.remove(usuarioRol);
        
        //Crear
        this.rol.setIdRol(5);
        this.rol.setRol("Junta Directiva");  
        this.usuarioRol.setRoles(rol);
        this.usuarioRol.setIdUsuario(user);
        this.usuariorolFacade.create(usuarioRol);
        this.juntaDirectiva.setIdjuntaDirectiva(this.userNew.getId());
        this.juntaDirectiva.setCargo(juntaDirectiva.getCargo());
        this.jDFacade.create(juntaDirectiva);
        
    return "cambiarMiembroJD1";
    }
    
    
    public JuntadirectivaController1() {
        
    }

    public JuntadirectivaFacade getjDFacade() {
        return jDFacade;
    }

    public void setjDFacade(JuntadirectivaFacade jDFacade) {
        this.jDFacade = jDFacade;
    }

    public UsuariosFacade getUsuariosFacade() {
        return usuariosFacade;
    }

    public void setUsuariosFacade(UsuariosFacade usuariosFacade) {
        this.usuariosFacade = usuariosFacade;
    }

    public int getIdJuntaDirectiva() {
        return idJuntaDirectiva;
    }

    public void setIdJuntaDirectiva(int idJuntaDirectiva) {
        this.idJuntaDirectiva = idJuntaDirectiva;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Juntadirectiva getJuntaDirectiva() {
        return juntaDirectiva;
    }

    public void setJuntaDirectiva(Juntadirectiva juntaDirectiva) {
        this.juntaDirectiva = juntaDirectiva;
    }

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }

    public Socios getSocio() {
        return socio;
    }

    public void setSocio(Socios socio) {
        this.socio = socio;
    }

    public SociosFacade getSociosFacade() {
        return sociosFacade;
    }

    public void setSociosFacade(SociosFacade sociosFacade) {
        this.sociosFacade = sociosFacade;
    }

    public RolFacade getRolfacade() {
        return rolfacade;
    }

    public void setRolfacade(RolFacade rolfacade) {
        this.rolfacade = rolfacade;
    }

    public UsuariorolesFacade getUsuariorolFacade() {
        return usuariorolFacade;
    }

    public void setUsuariorolFacade(UsuariorolesFacade usuariorolFacade) {
        this.usuariorolFacade = usuariorolFacade;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Rol getRolEliminar() {
        return rolEliminar;
    }

    public void setRolEliminar(Rol rolEliminar) {
        this.rolEliminar = rolEliminar;
    }

    public Usuarioroles getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(Usuarioroles usuarioRol) {
        this.usuarioRol = usuarioRol;
    }



    public Usuarios getUserNew() {
        return userNew;
    }

    public void setUserNew(Usuarios userNew) {
        this.userNew = userNew;
    }

    


    
}

    

