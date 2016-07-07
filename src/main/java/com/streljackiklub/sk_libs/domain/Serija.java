/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.streljackiklub.sk_libs.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dario
 */
@Entity
@Table(name = "serija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serija.findAll", query = "SELECT s FROM Serija s"),
    @NamedQuery(name = "Serija.findByTreningID", query = "SELECT s FROM Serija s WHERE s.serijaPK.treningID = :treningID"),
    @NamedQuery(name = "Serija.findByDeoTreningaID", query = "SELECT s FROM Serija s WHERE s.serijaPK.deoTreningaID = :deoTreningaID"),
    @NamedQuery(name = "Serija.findBySerijaID", query = "SELECT s FROM Serija s WHERE s.serijaPK.serijaID = :serijaID"),
    @NamedQuery(name = "Serija.findByRezultatSerije", query = "SELECT s FROM Serija s WHERE s.rezultatSerije = :rezultatSerije")})
public class Serija implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SerijaPK serijaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rezultatSerije")
    private Double rezultatSerije;
    @JoinColumns({
        @JoinColumn(name = "treningID", referencedColumnName = "treningID", insertable = false, updatable = false),
        @JoinColumn(name = "deoTreningaID", referencedColumnName = "deotreningaID", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private DeoTreninga deoTreninga;

    public Serija() {
        rezultatSerije = null;
    }

    public Serija(SerijaPK serijaPK) {
        this.serijaPK = serijaPK;
    }

    public Serija(int treningID, int deoTreningaID, int serijaID) {
        this.serijaPK = new SerijaPK(treningID, deoTreningaID, serijaID);
    }

    public SerijaPK getSerijaPK() {
        return serijaPK;
    }

    public void setSerijaPK(SerijaPK serijaPK) {
        this.serijaPK = serijaPK;
    }

    public Double getRezultatSerije() {
        return rezultatSerije;
    }

    public void setRezultatSerije(Double rezultatSerije) {
        this.rezultatSerije = rezultatSerije;
    }

    public DeoTreninga getDeoTreninga() {
        return deoTreninga;
    }

    public void setDeoTreninga(DeoTreninga deoTreninga) {
        this.deoTreninga = deoTreninga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serijaPK != null ? serijaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serija)) {
            return false;
        }
        Serija other = (Serija) object;
        if ((this.serijaPK == null && other.serijaPK != null) || (this.serijaPK != null && !this.serijaPK.equals(other.serijaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Serija[ serijaPK=" + serijaPK + " ]";
    }
    
    
    
}
