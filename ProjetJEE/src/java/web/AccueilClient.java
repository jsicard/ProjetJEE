/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.ClientFacadeLocal;
import dao.JeuxFacadeLocal;
import dao.LoueFacadeLocal;
import dao.PropriétaireFacadeLocal;
import dao.RegionGeoFacadeLocal;
import entity.Client;
import entity.Jeux;
import entity.Loue;
import entity.Propriétaire;
import entity.RegionGeo;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author sicar
 */
@Named(value = "accueilClient")
@SessionScoped
public class AccueilClient implements Serializable {
    
    @EJB
    ClientFacadeLocal clientDAO;
    Client client;
    @EJB
    JeuxFacadeLocal jeudao;
    Jeux jeu;
    @EJB
    LoueFacadeLocal louedao;
    Loue loue;
    @EJB
    PropriétaireFacadeLocal propriodao;
    Propriétaire proprio;
    @EJB
    RegionGeoFacadeLocal regiondao;
    RegionGeo region;
    
    /**
     * Creates a new instance of vue
     */
    public AccueilClient() {
        client = new Client();
    }
    
    public String getPrenomC(){
        client = clientDAO.find(1);
        return client.getPrenomC();
    };
    
    public List getListJeux(){
        List<Jeux> jeux = jeudao.findAll();
        return jeux;
    };
    
    public List getListRegion(){
        List<RegionGeo> regions = regiondao.findAll();
        return regions;
    };
    
    public void createClient(){
        clientDAO.create(client);
    }
    
    public void updateClient(){
        clientDAO.edit(client);
    }
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public RegionGeo getRegion() {
        return region;
    }

    public void setRegion(RegionGeo region) {
        this.region = region;
    }

    public Jeux getJeu() {
        return jeu;
    }

    public void setJeu(Jeux jeu) {
        this.jeu = jeu;
    }

    public Loue getLoue() {
        return loue;
    }

    public void setLoue(Loue loue) {
        this.loue = loue;
    }

    public Propriétaire getProprio() {
        return proprio;
    }

    public void setProprio(Propriétaire proprio) {
        this.proprio = proprio;
    }
}
