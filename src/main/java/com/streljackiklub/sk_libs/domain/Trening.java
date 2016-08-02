/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.streljackiklub.sk_libs.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.streljackiklub.sk_libs.json_view.View;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dario
 */
@Entity
@Table(name = "trening")
@XmlRootElement
@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@NamedQueries({
    @NamedQuery(name = "Trening.findAll", query = "SELECT t FROM Trening t ORDER BY t.datum DESC"),
    @NamedQuery(name = "Trening.findByTreningID", query = "SELECT t FROM Trening t WHERE t.treningID = :treningID"),
    @NamedQuery(name = "Trening.findByDatum", query = "SELECT t FROM Trening t WHERE t.datum = :datum"),
    @NamedQuery(name = "Trening.findByTrajanjeTreninga", query = "SELECT t FROM Trening t WHERE t.trajanjeTreninga = :trajanjeTreninga"),
    @NamedQuery(name = "Trening.findByClanId", query = "SELECT t FROM Trening t WHERE t.clan.clanID = :clanID ORDER BY t.datum DESC")})
public class Trening implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "treningID")
    @JsonView(View.Normal.class)
    private Integer treningID;
    
    @Column(name = "datum")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonView(View.Normal.class)
    private Date datum;
    
    @Column(name = "trajanjeTreninga")
    @JsonView(View.Normal.class)
    private Integer trajanjeTreninga;
    
//    @JsonManagedReference
    @JoinColumn(name = "clan", referencedColumnName = "clanID")
    @ManyToOne
    @JsonView(View.ExtendedTrening.class)
    private Clan clan;
    
//    @JsonManagedReference
    @JoinColumn(name = "trener", referencedColumnName = "trenerID")
    @ManyToOne
    @JsonView(View.ExtendedTrening.class)
    private Trener trener;
    
//    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trening")
    @JsonView(View.Normal.class)
    private List<DeoTreninga> deoTreningaList;

    public Trening() {
        deoTreningaList = new ArrayList<>();
        treningID = -3;
    }

    public Trening(Integer treningID) {
        this.treningID = treningID;
    }
    
    public String vratiStringDelova(){
        if(deoTreningaList != null && deoTreningaList.size() > 0){
            String val = "[";
            for (DeoTreninga dt : deoTreningaList) {
                val = val + dt.getRezultat() + "] ";
            }
            return val;
        }
        return deoTreningaList.size() + "";
    }

    public Integer getTreningID() {
        return treningID;
    }

    public void setTreningID(Integer treningID) {
        this.treningID = treningID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Integer getTrajanjeTreninga() {
        return trajanjeTreninga;
    }

    public void setTrajanjeTreninga(Integer trajanjeTreninga) {
        this.trajanjeTreninga = trajanjeTreninga;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
    }

    @XmlTransient
    public List<DeoTreninga> getDeoTreningaList() {
        return deoTreningaList;
    }

    public void setDeoTreningaList(List<DeoTreninga> deoTreningaList) {
        this.deoTreningaList = deoTreningaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (treningID != null ? treningID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trening)) {
            return false;
        }
        Trening other = (Trening) object;
        if ((this.treningID == null && other.treningID != null) || (this.treningID != null && !this.treningID.equals(other.treningID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Trening[ treningID=" + treningID + " ]";
    }
    
}
