/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.facade;

import edu.entity.Gerente;
import edu.entity.Usuarioroles;
import edu.entity.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author usuario
 */
@Stateless
public class UsuariorolesFacade extends AbstractFacade<Usuarioroles> {

    @PersistenceContext(unitName = "RolesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariorolesFacade() {
        super(Usuarioroles.class);
    }
    
       public Usuarios login(int idUsuario, String contrasena) {
        Usuarios objDatos = new Usuarios();
        objDatos.setNombre("vacio");
        Query q;
        q = em.createQuery("select u from Usuarios u where u.id = :id and u.contrasena =:con");
        q.setParameter("id", idUsuario);
        q.setParameter("con", contrasena);

        List<Usuarios> miLista = q.getResultList();
        if (miLista.isEmpty()) {
            return objDatos;
        } else {
            return miLista.get(0);

        }
    }
    
       public List<Usuarios> traerUsuarios(){
       List<Usuarios> u;
       Query q;
       
       q= em.createQuery("select u from Usuarios u where u.id = u.socios.idSocios");
       u= q.getResultList();
       return u;
       
       
       }
       
        public List<Usuarioroles> traerGerente(int rol,int id){
    List<Usuarioroles> ur;
    Query q;
    q=em.createQuery("SELECT u FROM Usuarioroles u WHERE u.roles = ? and u.idUsuario = ?");
    ur= (List<Usuarioroles>) q.getSingleResult();
    
    return ur;
    }
       
    
     public List<Usuarioroles> traerSocioNewMAnager(int id){
        List<Usuarioroles> ur;
        Query q;
        q=em.createQuery("select r from Usuarioroles r where r.roles = 2 and r.idUsuario = "+id);
        ur= q.getResultList();
        
        return ur;
        }
     
     
     
    
}
