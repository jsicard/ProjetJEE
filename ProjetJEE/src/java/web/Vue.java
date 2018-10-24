/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.ClientFacadeLocal;
import entity.Client;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author sicar
 */
@Named(value = "vue")
@SessionScoped
public class Vue implements Serializable {
    
    @EJB
    ClientFacadeLocal clientDAO;
    Client client;
    /**
     * Creates a new instance of vue
     */
    public Vue() {
        client = new Client();
    }
    
    public String getNom(){
        Client client = clientDAO.find(1);
        return client.getNomC();
    };
    
    public List getList(){
        List<Client> client = clientDAO.findAll();
        return client;
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
    
}
