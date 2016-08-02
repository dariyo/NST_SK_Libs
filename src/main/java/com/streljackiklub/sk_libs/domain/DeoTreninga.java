/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.streljackiklub.sk_libs.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.streljackiklub.sk_libs.json_view.View;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dario
 */
@Entity
@Table(name = "deotreninga")
@XmlRootElement
@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@NamedQueries({
    @NamedQuery(name = "DeoTreninga.findAll", query = "SELECT d FROM DeoTreninga d"),
    @NamedQuery(name = "DeoTreninga.findByTreningID", query = "SELECT d FROM DeoTreninga d WHERE d.deoTreningaPK.treningID = :treningID"),
    @NamedQuery(name = "DeoTreninga.findByDeotreningaID", query = "SELECT d FROM DeoTreninga d WHERE d.deoTreningaPK.deotreningaID = :deotreningaID"),
    @NamedQuery(name = "DeoTreninga.findByOpis", query = "SELECT d FROM DeoTreninga d WHERE d.opis = :opis"),
    @NamedQuery(name = "DeoTreninga.findByDodatniOpis", query = "SELECT d FROM DeoTreninga d WHERE d.dodatniOpis = :dodatniOpis"),
    @NamedQuery(name = "DeoTreninga.findByBrojSerija", query = "SELECT d FROM DeoTreninga d WHERE d.brojSerija = :brojSerija"),
    @NamedQuery(name = "DeoTreninga.findByVelicinaSerije", query = "SELECT d FROM DeoTreninga d WHERE d.velicinaSerije = :velicinaSerije"),
    @NamedQuery(name = "DeoTreninga.findByRezultat", query = "SELECT d FROM DeoTreninga d WHERE d.rezultat = :rezultat")})
public class DeoTreninga implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    @JsonView(View.Normal.class)
    protected DeoTreningaPK deoTreningaPK;
    
    @Size(max = 250)
    @Column(name = "opis")
    @JsonView(View.Normal.class)
    private String opis;
    
    @Size(max = 250)
    @Column(name = "dodatniOpis")
    @JsonView(View.Normal.class)
    private String dodatniOpis;
    
    @Column(name = "brojSerija")
    @JsonView(View.Normal.class)
    private Integer brojSerija;
    
    @Column(name = "velicinaSerije")
    @JsonView(View.Normal.class)
    private Integer velicinaSerije;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "rezultat")
    @JsonView(View.Normal.class)
    private Double rezultat;
    
//    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deoTreninga")
    @JsonView(View.Normal.class)
    private List<Serija> serijaList;
    
//    @JsonBackReference
    @JoinColumn(name = "treningID", referencedColumnName = "treningID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonView(View.ExtendedDeoTrening.class)
    private Trening trening;

    public DeoTreninga() {
        serijaList = new ArrayList<>();
    }

    public DeoTreninga(DeoTreningaPK deoTreningaPK) {
        this.deoTreningaPK = deoTreningaPK;
    }

    public DeoTreninga(int treningID, int deotreningaID) {
        this.deoTreningaPK = new DeoTreningaPK(treningID, deotreningaID);
    }

    public DeoTreningaPK getDeoTreningaPK() {
        return deoTreningaPK;
    }

    public void setDeoTreningaPK(DeoTreningaPK deoTreningaPK) {
        this.deoTreningaPK = deoTreningaPK;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getDodatniOpis() {
        return dodatniOpis;
    }

    public void setDodatniOpis(String dodatniOpis) {
        this.dodatniOpis = dodatniOpis;
    }

    public Integer getBrojSerija() {
        return brojSerija;
    }

    public void setBrojSerija(Integer brojSerija) {
        this.brojSerija = brojSerija;
    }

    public Integer getVelicinaSerije() {
        return velicinaSerije;
    }

    public void setVelicinaSerije(Integer velicinaSerije) {
        this.velicinaSerije = velicinaSerije;
    }

    public Double getRezultat() {
        return rezultat;
    }

    public void setRezultat(Double rezultat) {
        this.rezultat = rezultat;
    }

    @XmlTransient
    public List<Serija> getSerijaList() {
        return serijaList;
    }

    public void setSerijaList(List<Serija> serijaList) {
        this.serijaList = serijaList;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deoTreningaPK != null ? deoTreningaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeoTreninga)) {
            return false;
        }
        DeoTreninga other = (DeoTreninga) object;
        if ((this.deoTreningaPK == null && other.deoTreningaPK != null) || (this.deoTreningaPK != null && !this.deoTreningaPK.equals(other.deoTreningaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.DeoTreninga[ deoTreningaPK=" + deoTreningaPK + " ]";
    }

    public String ispisiSerije() {
        String ispis = "";
        if (serijaList != null) {
            for (int i = 0; i < serijaList.size(); i++) {
                if (i != 0) {
                    ispis += ", ";
                }
                ispis += serijaList.get(i).getRezultatSerije();
            }
        }
        return ispis;
    }

}
