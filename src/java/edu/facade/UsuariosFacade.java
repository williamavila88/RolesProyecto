/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.facade;

import edu.entity.Gerente;
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
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "RolesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
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
    public List<Usuarios> traerGerenteList(){
   Query q;
   q= em.createQuery("select u from Usuarios u where u.id = u.gerente.idGerente");
    List<Usuarios> u   = q.getResultList();
       
    
    return u;
    }
    
    
    public List<Usuarios> traerSocios(){
   Query q;
   q= em.createQuery("select u from Usuarios u where u.id = u.socios.idSocios");
    List<Usuarios> u   = q.getResultList();
       
    
    return u;
    }
    public Usuarios traerGerente(){
    Usuarios u;
    Query q;
    q=em.createQuery("select u from Usuarios u where u.id= u.gerente.idGerente");
    u= (Usuarios) q.getSingleResult();
    return u;
    }
public List<Gerente> getGerente(){
     List<Gerente> g;
     Query q;
     q=em.createQuery("select * from Gerente g");
     g=q.getResultList();
     
     return g;
     
     }

public Usuarios getVistaGerente(){
Usuarios u;
Query q;
q= em.createQuery("select u from Usuarios u where u.rol = 2 ");
u= (Usuarios) q.getSingleResult();
return u;
}

public Usuarios getVistaSocio(int id){
Usuarios u;
Query q;
q= em.createQuery("select u from Usuarios u where u.rol = 5 and u.id = "+id);
u= (Usuarios) q.getSingleResult();
return u;
}


}
