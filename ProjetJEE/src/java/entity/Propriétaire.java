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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "propri\u00e9taire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propri\u00e9taire.findAll", query = "SELECT p FROM Propri\u00e9taire p")
    , @NamedQuery(name = "Propri\u00e9taire.findByIdProprietaire", query = "SELECT p FROM Propri\u00e9taire p WHERE p.idProprietaire = :idProprietaire")
    , @NamedQuery(name = "Propri\u00e9taire.findByNom", query = "SELECT p FROM Propri\u00e9taire p WHERE p.nom = :nom")
    , @NamedQuery(name = "Propri\u00e9taire.findByPrenom", query = "SELECT p FROM Propri\u00e9taire p WHERE p.prenom = :prenom")
    , @NamedQuery(name = "Propri\u00e9taire.findByNote", query = "SELECT p FROM Propri\u00e9taire p WHERE p.note = :note")
    , @NamedQuery(name = "Propri\u00e9taire.findByCarteId", query = "SELECT p FROM Propri\u00e9taire p WHERE p.carteId = :carteId")})
public class Propriétaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProprietaire")
    private Integer idProprietaire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Adresse")
    private String adresse;
    @Column(name = "Note")
    private Integer note;
    @Lob
    @Size(max = 65535)
    @Column(name = "Commentaire")
    private String commentaire;
    @Size(max = 50)
    @Column(name = "CarteId")
    private String carteId;
    @JoinColumn(name = "nomRegion", referencedColumnName = "nomRegion")
    @ManyToOne(optional = false)
    private RegionGeo nomRegion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProprietaire")
    private Collection<Jeux> jeuxCollection;

    public Propriétaire() {
    }

    public Propriétaire(Integer idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public Propriétaire(Integer idProprietaire, String nom, String prenom, String adresse) {
        this.idProprietaire = idProprietaire;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public Integer getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(Integer idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getCarteId() {
        return carteId;
    }

    public void setCarteId(String carteId) {
        this.carteId = carteId;
    }

    public RegionGeo getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(RegionGeo nomRegion) {
        this.nomRegion = nomRegion;
    }

    @XmlTransient
    public Collection<Jeux> getJeuxCollection() {
        return jeuxCollection;
    }

    public void setJeuxCollection(Collection<Jeux> jeuxCollection) {
        this.jeuxCollection = jeuxCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProprietaire != null ? idProprietaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propriétaire)) {
            return false;
        }
        Propriétaire other = (Propriétaire) object;
        if ((this.idProprietaire == null && other.idProprietaire != null) || (this.idProprietaire != null && !this.idProprietaire.equals(other.idProprietaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Propri\u00e9taire[ idProprietaire=" + idProprietaire + " ]";
    }
    
}
