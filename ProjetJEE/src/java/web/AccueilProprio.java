/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.JeuxFacadeLocal;
import entity.Jeux;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author sicar
 */
@Named(value = "accueilProprio")
@SessionScoped
public class AccueilProprio implements Serializable {

    @EJB
    JeuxFacadeLocal jeudao;
    Jeux jeu;
    private int idJeu; 
    /**
     * Creates a new instance of AccueilProprio
     */
    public AccueilProprio() {
        
    }
    
    public void removeJeux(){
        Jeux unJeu = jeudao.find(idJeu);
        jeudao.remove(unJeu);
    }
    
    public void updateJeux(){
        Jeux newJeux = jeudao.find(idJeu);
        newJeux.setNom(jeu.getNom());
        newJeux.setAuteur(jeu.getAuteur());
        newJeux.setResume(jeu.getResume());
        newJeux.setPrix(jeu.getPrix());
        newJeux.setSupport(jeu.getSupport());
        jeudao.edit(newJeux);
    }
    
}
