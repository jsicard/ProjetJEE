/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sicar
 */
@Embeddable
public class LouePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idJeux")
    private int idJeux;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idClient")
    private int idClient;

    public LouePK() {
    }

    public LouePK(int idJeux, int idClient) {
        this.idJeux = idJeux;
        this.idClient = idClient;
    }

    public int getIdJeux() {
        return idJeux;
    }

    public void setIdJeux(int idJeux) {
        this.idJeux = idJeux;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idJeux;
        hash += (int) idClient;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LouePK)) {
            return false;
        }
        LouePK other = (LouePK) object;
        if (this.idJeux != other.idJeux) {
            return false;
        }
        if (this.idClient != other.idClient) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LouePK[ idJeux=" + idJeux + ", idClient=" + idClient + " ]";
    }
    
}
