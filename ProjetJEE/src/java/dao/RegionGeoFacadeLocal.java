/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.RegionGeo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sicar
 */
@Local
public interface RegionGeoFacadeLocal {

    void create(RegionGeo regionGeo);

    void edit(RegionGeo regionGeo);

    void remove(RegionGeo regionGeo);

    RegionGeo find(Object id);

    List<RegionGeo> findAll();

    List<RegionGeo> findRange(int[] range);

    int count();
    
}
