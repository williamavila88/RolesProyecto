/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.facade;

import edu.entity.Novedades;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author usuario
 */
@Stateless
public class NovedadesFacade extends AbstractFacade<Novedades> {

    @PersistenceContext(unitName = "RolesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NovedadesFacade() {
        super(Novedades.class);
    }
    
}
