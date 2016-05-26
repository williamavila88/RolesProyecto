/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.facade;

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
    
    
}
