/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.JeuxFacadeLocal;
import dao.PropriétaireFacadeLocal;
import entity.Jeux;
import entity.Propriétaire;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author sicar
 */
@Named(value = "locationClient")
@SessionScoped
public class LocationClient implements Serializable {

    @EJB
    PropriétaireFacadeLocal propriodao;
    Propriétaire proprio;
    @EJB
    JeuxFacadeLocal jeudao;
    Jeux jeu;
    /**
     * Creates a new instance of LocationClient
     */
    public LocationClient() {
    }

    public Propriétaire getProprio() {
        return proprio;
    }

    public void setProprio(Propriétaire proprio) {
        this.proprio = proprio;
    }

    public Jeux getJeu() {
        return jeu;
    }

    public void setJeu(Jeux jeu) {
        this.jeu = jeu;
    }
    
}
