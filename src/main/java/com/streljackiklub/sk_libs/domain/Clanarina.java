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
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dario
 */
@Entity
@Table(name = "clanarina")
@XmlRootElement
@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@NamedQueries({
    @NamedQuery(name = "Clanarina.findAll", query = "SELECT c FROM Clanarina c"),
    @NamedQuery(name = "Clanarina.findByClanID", query = "SELECT c FROM Clanarina c WHERE c.clanarinaPK.clanID = :clanID ORDER BY c.datumDo DESC"),
    @NamedQuery(name = "Clanarina.findByClanarinaID", query = "SELECT c FROM Clanarina c WHERE c.clanarinaPK.clanarinaID = :clanarinaID"),
    @NamedQuery(name = "Clanarina.findByDatumDo", query = "SELECT c FROM Clanarina c WHERE c.datumDo = :datumDo"),
    @NamedQuery(name = "Clanarina.findByClanIDAndDatumDo", query = "SELECT c FROM Clanarina c WHERE c.clanarinaPK.clanID = :clanID AND c.datumDo = :datumDo"),
    @NamedQuery(name = "Clanarina.findByIznos", query = "SELECT c FROM Clanarina c WHERE c.iznos = :iznos")})
public class Clanarina implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    @JsonView(View.Normal.class)
    protected ClanarinaPK clanarinaPK;
    
//    @Column(name = "datumOd")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date datumOd;
    
    @Column(name = "datumDo")
    @Temporal(TemporalType.DATE)
    @JsonView(View.Normal.class)
    private Date datumDo;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "iznos")
    @JsonView(View.Normal.class)
    private Double iznos;
    
    @JoinColumn(name = "clanID", referencedColumnName = "clanID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonView(View.ExtendedClanarina.class)
    private Clan clan;

    public Clanarina() {
    }

    public Clanarina(ClanarinaPK clanarinaPK) {
        this.clanarinaPK = clanarinaPK;
    }

    public Clanarina(int clanID, int clanarinaID) {
        this.clanarinaPK = new ClanarinaPK(clanID, clanarinaID);
    }

    public ClanarinaPK getClanarinaPK() {
        return clanarinaPK;
    }

    public void setClanarinaPK(ClanarinaPK clanarinaPK) {
        this.clanarinaPK = clanarinaPK;
    }
//
//    public Date getDatumOd() {
//        return datumOd;
//    }
//
//    public void setDatumOd(Date datumOd) {
//        this.datumOd = datumOd;
//    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public Double getIznos() {
        return iznos;
    }

    public void setIznos(Double iznos) {
        this.iznos = iznos;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clanarinaPK != null ? clanarinaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clanarina)) {
            return false;
        }
        Clanarina other = (Clanarina) object;
        if ((this.clanarinaPK == null && other.clanarinaPK != null) || (this.clanarinaPK != null && !this.clanarinaPK.equals(other.clanarinaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Clanarina[ clanarinaPK=" + clanarinaPK + " ]";
    }
    
}
