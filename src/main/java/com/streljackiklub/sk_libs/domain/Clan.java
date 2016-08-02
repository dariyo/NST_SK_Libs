/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.streljackiklub.sk_libs.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dario
 */
@Entity
@Table(name = "clan")
@XmlRootElement
@JsonSerialize
@NamedQueries({
    @NamedQuery(name = "Clan.findAll", query = "SELECT c FROM Clan c"),
    @NamedQuery(name = "Clan.findByClanID", query = "SELECT c FROM Clan c WHERE c.clanID = :clanID"),
    @NamedQuery(name = "Clan.findByJmbg", query = "SELECT c FROM Clan c WHERE c.jmbg = :jmbg"),
    @NamedQuery(name = "Clan.findByIme", query = "SELECT c FROM Clan c WHERE c.ime = :ime"),
    @NamedQuery(name = "Clan.findByPrezime", query = "SELECT c FROM Clan c WHERE c.prezime = :prezime"),
    @NamedQuery(name = "Clan.findByDatumRodjenja", query = "SELECT c FROM Clan c WHERE c.datumRodjenja = :datumRodjenja"),
    @NamedQuery(name = "Clan.findByDatumUclanjenja", query = "SELECT c FROM Clan c WHERE c.datumUclanjenja = :datumUclanjenja"),
    @NamedQuery(name = "Clan.findByKategorija", query = "SELECT c FROM Clan c WHERE c.kategorija = :kategorija"),
    @NamedQuery(name = "Clan.findByOruzje", query = "SELECT c FROM Clan c WHERE c.oruzje = :oruzje"),
    @NamedQuery(name = "Clan.findByLicencaStrelca", query = "SELECT c FROM Clan c WHERE c.licencaStrelca = :licencaStrelca"),
    @NamedQuery(name = "Clan.findByTelefon", query = "SELECT c FROM Clan c WHERE c.telefon = :telefon")})
@JsonInclude(Include.NON_NULL)
public class Clan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "clanID")
    @JsonView(View.Normal.class)
    private Integer clanID;
    @Size(max = 13)
    @Column(name = "jmbg")
    @JsonView(View.Normal.class)
    private String jmbg;
    @Size(max = 30)
    @Column(name = "ime")
    @JsonView(View.Normal.class)
    private String ime;
    @Size(max = 30)
    @Column(name = "prezime")
    @JsonView(View.Normal.class)
    private String prezime;
    @Column(name = "datumRodjenja")
    @Temporal(TemporalType.DATE)
    @JsonView(View.Normal.class)
    private Date datumRodjenja;
    @Column(name = "datumUclanjenja")
    @Temporal(TemporalType.DATE)
    @JsonView(View.Normal.class)
    private Date datumUclanjenja;
    @Size(max = 30)
    @Column(name = "kategorija")
    @JsonView(View.Normal.class)
    private String kategorija;
    @Size(max = 50)
    @Column(name = "oruzje")
    @JsonView(View.Normal.class)
    private String oruzje;
    @Size(max = 10)
    @Column(name = "licencaStrelca")
    @JsonView(View.Normal.class)
    private String licencaStrelca;
    @Size(max = 15)
    @Column(name = "telefon")
    @JsonView(View.Normal.class)
    private String telefon;
//    @JsonBackReference
    @OneToMany(mappedBy = "clan")
    @OrderBy("datum DESC")
    @JsonView(View.ExtendedClan.class)
    private List<Trening> treningList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clan")
    @OrderBy("datumDo DESC")
    @JsonView(View.ExtendedClan.class)
    private List<Clanarina> clanarinaList;

    public Clan() {
        treningList = new ArrayList<>();
        clanarinaList = new ArrayList<>();
        clanID = -3;
    }

    public Clan(Integer clanID) {
        this();
        this.clanID = clanID;
    }

    public Integer getClanID() {
        return clanID;
    }

    public void setClanID(Integer clanID) {
        this.clanID = clanID;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Date getDatumUclanjenja() {
        return datumUclanjenja;
    }

    public void setDatumUclanjenja(Date datumUclanjenja) {
        this.datumUclanjenja = datumUclanjenja;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getOruzje() {
        return oruzje;
    }

    public void setOruzje(String oruzje) {
        this.oruzje = oruzje;
    }

    public String getLicencaStrelca() {
        return licencaStrelca;
    }

    public void setLicencaStrelca(String licencaStrelca) {
        this.licencaStrelca = licencaStrelca;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @XmlTransient
    public List<Trening> getTreningList() {
        return treningList;
    }

    public void setTreningList(List<Trening> treningList) {
        this.treningList = treningList;
    }

    @XmlTransient
    public List<Clanarina> getClanarinaList() {
        return clanarinaList;
    }

    public void setClanarinaList(List<Clanarina> clanarinaList) {
        this.clanarinaList = clanarinaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clanID != null ? clanID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clan)) {
            return false;
        }
        Clan other = (Clan) object;
        if ((this.clanID == null && other.clanID != null) || (this.clanID != null && !this.clanID.equals(other.clanID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }
    
}
