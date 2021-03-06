/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Propriétaire;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sicar
 */
@Stateless
public class PropriétaireFacade extends AbstractFacade<Propriétaire> implements PropriétaireFacadeLocal {

    @PersistenceContext(unitName = "ProjetJEEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PropriétaireFacade() {
        super(Propriétaire.class);
    }
    
}
