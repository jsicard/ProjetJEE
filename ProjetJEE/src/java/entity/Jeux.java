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
@Table(name = "jeux")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jeux.findAll", query = "SELECT j FROM Jeux j")
    , @NamedQuery(name = "Jeux.findByIdJeux", query = "SELECT j FROM Jeux j WHERE j.idJeux = :idJeux")
    , @NamedQuery(name = "Jeux.findByNom", query = "SELECT j FROM Jeux j WHERE j.nom = :nom")
    , @NamedQuery(name = "Jeux.findByAuteur", query = "SELECT j FROM Jeux j WHERE j.auteur = :auteur")
    , @NamedQuery(name = "Jeux.findByPrix", query = "SELECT j FROM Jeux j WHERE j.prix = :prix")
    , @NamedQuery(name = "Jeux.findByNote", query = "SELECT j FROM Jeux j WHERE j.note = :note")
    , @NamedQuery(name = "Jeux.findBySupport", query = "SELECT j FROM Jeux j WHERE j.support = :support")})
public class Jeux implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idJeux")
    private Integer idJeux;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Auteur")
    private String auteur;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Resume")
    private String resume;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Prix")
    private int prix;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Note")
    private int note;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Commentaire")
    private String commentaire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Support")
    private String support;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jeux")
    private Collection<Loue> loueCollection;
    @JoinColumn(name = "idProprietaire", referencedColumnName = "idProprietaire")
    @ManyToOne(optional = false)
    private Propriétaire idProprietaire;

    public Jeux() {
    }

    public Jeux(Integer idJeux) {
        this.idJeux = idJeux;
    }

    public Jeux(Integer idJeux, String nom, String auteur, String resume, int prix, int note, String commentaire, String support) {
        this.idJeux = idJeux;
        this.nom = nom;
        this.auteur = auteur;
        this.resume = resume;
        this.prix = prix;
        this.note = note;
        this.commentaire = commentaire;
        this.support = support;
    }

    public Integer getIdJeux() {
        return idJeux;
    }

    public void setIdJeux(Integer idJeux) {
        this.idJeux = idJeux;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    @XmlTransient
    public Collection<Loue> getLoueCollection() {
        return loueCollection;
    }

    public void setLoueCollection(Collection<Loue> loueCollection) {
        this.loueCollection = loueCollection;
    }

    public Propriétaire getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(Propriétaire idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJeux != null ? idJeux.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jeux)) {
            return false;
        }
        Jeux other = (Jeux) object;
        if ((this.idJeux == null && other.idJeux != null) || (this.idJeux != null && !this.idJeux.equals(other.idJeux))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Jeux[ idJeux=" + idJeux + " ]";
    }
    
}
