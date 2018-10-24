/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Loue;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sicar
 */
@Local
public interface LoueFacadeLocal {

    void create(Loue loue);

    void edit(Loue loue);

    void remove(Loue loue);

    Loue find(Object id);

    List<Loue> findAll();

    List<Loue> findRange(int[] range);

    int count();
    
}
