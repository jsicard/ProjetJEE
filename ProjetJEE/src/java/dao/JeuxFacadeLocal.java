/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Jeux;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sicar
 */
@Local
public interface JeuxFacadeLocal {

    void create(Jeux jeux);

    void edit(Jeux jeux);

    void remove(Jeux jeux);

    Jeux find(Object id);

    List<Jeux> findAll();

    List<Jeux> findRange(int[] range);

    int count();
    
}
