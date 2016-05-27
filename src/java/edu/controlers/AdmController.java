/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.controlers;

import edu.entity.Gerente;
import edu.entity.Rol;
import edu.entity.Secretaria;
import edu.entity.Usuarioroles;

import edu.entity.Usuarios;
import edu.facade.GerenteFacade;
import edu.facade.RolFacade;
import edu.facade.SecretariaFacade;
import edu.facade.UsuariorolesFacade;
import edu.facade.UsuariosFacade;
import java.io.Serializable;

import java.util.List;

import javax.ejb.EJB;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



/**
 *
 * @author Bebe
 */
@ManagedBean
@RequestScoped
public class AdmController {

    @EJB
    UsuariosFacade usuariosFacade;
    @EJB
    GerenteFacade g;
    @EJB
    RolFacade rolesFacade;
    @EJB
    UsuariorolesFacade usuarioRolesFacade;
    @EJB
    SecretariaFacade secretariaF;
    @EJB
    GerenteFacade gerentef;
    
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String correo;
    private String fechaNacimiento;
    private String telefono;
    private String usuario;
    private String contrasena;
  
    Usuarios user=new Usuarios();

    Secretaria secretaria = new Secretaria();
    Usuarios usuarios = new Usuarios();
    Gerente gerente = new Gerente();

    public List<Usuarios> listarSecretaria() {
        return this.usuariosFacade.findAll();
    }

    public List<Usuarios> listarGerente() {
        return this.usuariosFacade.findAll();

    }

    public String eliminarSecretaria(Usuarios r) {
        this.usuariosFacade.remove(r);
        return "listarSecretaria";
    }

    public String eliminarGerente(Usuarios r) {
        this.usuariosFacade.remove(r);
        //this.usuariosFacade.remove(r.getIdUsuario());
        //this.rolesFacade.remove(r.getRoles());

        return "listarGerente";

    }

    public String crearSecretaria() {
        Rol rol = new Rol();

        rol.setIdRol(3);
        rol.setRol("Secretaria");

        Usuarios usur = new Usuarios();
        usur.setId(id);
        usur.setApelido(apellido);
        usur.setNombre(nombre);

        usur.setDireccion(direccion);
        usur.setCorreo(correo);

        Usuarioroles usuro = new Usuarioroles();

        this.usuariosFacade.create(usur);
        usuro.setRoles(rol);
        usuro.setIdUsuario(usur);
        this.usuarioRolesFacade.create(usuro);

        Secretaria secretaria = new Secretaria();
        secretaria.setIdSecretaria(id);
        secretaria.setSalario(1200000);
        secretaria.setCarne(id);

        this.secretariaF.create(secretaria);

        return "listarSecretaria";
    }

    public String crearGerente() {

        Rol rol = new Rol();

        rol.setIdRol(2);
        rol.setRol("Gerente");

        Usuarios usur = new Usuarios();
        usur.setId(id);
        usur.setApelido(apellido);
        usur.setNombre(nombre);

        usur.setDireccion(direccion);
        usur.setCorreo(correo);

        Usuarioroles usuro = new Usuarioroles();

        this.usuariosFacade.create(usur);
        usuro.setRoles(rol);
        usuro.setIdUsuario(usur);
        this.usuarioRolesFacade.create(usuro);

        Gerente gerente = new Gerente();
        gerente.setIdGerente(id);
        gerente.setSalario("3000000");
        this.g.create(gerente);

        return "listarGerente";
    }

    public String editarSecretaria(Usuarios u) {
       this.usuariosFacade.edit(u);

        return "listarSecretaria";
    }

    public String editarGerente(Usuarios u) {
        this.usuariosFacade.edit(u);
        return "listarGerentes";
    }
    public String mostrarGerente(){
    return "editarGerente";
    }
    public String mostrarSecretaria() {

        return "editarSecretaria";
    }

 
    
    
            
            

    public AdmController() {
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

    public RolFacade getRolesFacade() {
        return rolesFacade;
    }

    public void setRolesFacade(RolFacade rolesFacade) {
        this.rolesFacade = rolesFacade;
    }

    public UsuariorolesFacade getUsuarioRolesFacade() {
        return usuarioRolesFacade;
    }

    public void setUsuarioRolesFacade(UsuariorolesFacade usuarioRolesFacade) {
        this.usuarioRolesFacade = usuarioRolesFacade;
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

    public SecretariaFacade getSecretariaF() {
        return secretariaF;
    }

    public void setSecretariaF(SecretariaFacade secretariaF) {
        this.secretariaF = secretariaF;
    }

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
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

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public UsuariosFacade getUsuariosFacade() {
        return usuariosFacade;
    }

    public void setUsuariosFacade(UsuariosFacade usuariosFacade) {
        this.usuariosFacade = usuariosFacade;
    }

    public GerenteFacade getG() {
        return g;
    }

    public void setG(GerenteFacade g) {
        this.g = g;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

}
