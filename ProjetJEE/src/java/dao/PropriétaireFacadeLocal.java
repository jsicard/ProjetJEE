/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Propriétaire;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sicar
 */
@Local
public interface PropriétaireFacadeLocal {

    void create(Propriétaire propriétaire);

    void edit(Propriétaire propriétaire);

    void remove(Propriétaire propriétaire);

    Propriétaire find(Object id);

    List<Propriétaire> findAll();

    List<Propriétaire> findRange(int[] range);

    int count();
    
}
