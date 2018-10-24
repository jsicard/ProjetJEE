/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sicar
 */
@Entity
@Table(name = "region_geo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegionGeo.findAll", query = "SELECT r FROM RegionGeo r")
    , @NamedQuery(name = "RegionGeo.findByNomRegion", query = "SELECT r FROM RegionGeo r WHERE r.nomRegion = :nomRegion")})
public class RegionGeo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nomRegion")
    private String nomRegion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nomRegion")
    private Collection<Propriétaire> propriétaireCollection;

    public RegionGeo() {
    }

    public RegionGeo(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    @XmlTransient
    public Collection<Propriétaire> getPropriétaireCollection() {
        return propriétaireCollection;
    }

    public void setPropriétaireCollection(Collection<Propriétaire> propriétaireCollection) {
        this.propriétaireCollection = propriétaireCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomRegion != null ? nomRegion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegionGeo)) {
            return false;
        }
        RegionGeo other = (RegionGeo) object;
        if ((this.nomRegion == null && other.nomRegion != null) || (this.nomRegion != null && !this.nomRegion.equals(other.nomRegion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RegionGeo[ nomRegion=" + nomRegion + " ]";
    }
    
}
