/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sicar
 */
@Entity
@Table(name = "loue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loue.findAll", query = "SELECT l FROM Loue l")
    , @NamedQuery(name = "Loue.findByIdJeux", query = "SELECT l FROM Loue l WHERE l.louePK.idJeux = :idJeux")
    , @NamedQuery(name = "Loue.findByIdClient", query = "SELECT l FROM Loue l WHERE l.louePK.idClient = :idClient")
    , @NamedQuery(name = "Loue.findByDuree", query = "SELECT l FROM Loue l WHERE l.duree = :duree")})
public class Loue implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LouePK louePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Duree")
    private int duree;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "idJeux", referencedColumnName = "idJeux", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Jeux jeux;

    public Loue() {
    }

    public Loue(LouePK louePK) {
        this.louePK = louePK;
    }

    public Loue(LouePK louePK, int duree) {
        this.louePK = louePK;
        this.duree = duree;
    }

    public Loue(int idJeux, int idClient) {
        this.louePK = new LouePK(idJeux, idClient);
    }

    public LouePK getLouePK() {
        return louePK;
    }

    public void setLouePK(LouePK louePK) {
        this.louePK = louePK;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Jeux getJeux() {
        return jeux;
    }

    public void setJeux(Jeux jeux) {
        this.jeux = jeux;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (louePK != null ? louePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loue)) {
            return false;
        }
        Loue other = (Loue) object;
        if ((this.louePK == null && other.louePK != null) || (this.louePK != null && !this.louePK.equals(other.louePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Loue[ louePK=" + louePK + " ]";
    }
    
}
