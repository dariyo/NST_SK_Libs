/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.streljackiklub.sk_libs.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
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
 * @author Dario
 */
@Entity
@Table(name = "trener")
@XmlRootElement
@JsonSerialize@JsonInclude(JsonInclude.Include.NON_NULL)

@NamedQueries({
    @NamedQuery(name = "Trener.findAll", query = "SELECT t FROM Trener t"),
    @NamedQuery(name = "Trener.findByTrenerID", query = "SELECT t FROM Trener t WHERE t.trenerID = :trenerID"),
    @NamedQuery(name = "Trener.findByJmbg", query = "SELECT t FROM Trener t WHERE t.jmbg = :jmbg"),
    @NamedQuery(name = "Trener.findByIme", query = "SELECT t FROM Trener t WHERE t.ime = :ime"),
    @NamedQuery(name = "Trener.findByPrezime", query = "SELECT t FROM Trener t WHERE t.prezime = :prezime"),
    @NamedQuery(name = "Trener.findByLicencaTrenera", query = "SELECT t FROM Trener t WHERE t.licencaTrenera = :licencaTrenera"),
    @NamedQuery(name = "Trener.findByKorisnickoIme", query = "SELECT t FROM Trener t WHERE t.korisnickoIme = :korisnickoIme"),
    @NamedQuery(name = "Trener.findByKorisnickoImeAndSifra", query = "SELECT t FROM Trener t WHERE t.korisnickoIme = :korisnickoIme AND t.sifra = :sifra"),
    @NamedQuery(name = "Trener.findBySifra", query = "SELECT t FROM Trener t WHERE t.sifra = :sifra")})
public class Trener implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "trenerID")
    private Integer trenerID;
    @Size(max = 13)
    @Column(name = "jmbg")
    private String jmbg;
    @Size(max = 30)
    @Column(name = "ime")
    private String ime;
    @Size(max = 30)
    @Column(name = "prezime")
    private String prezime;
    @Size(max = 10)
    @Column(name = "licencaTrenera")
    private String licencaTrenera;
    @Size(max = 20)
    @Column(name = "korisnickoIme")
    private String korisnickoIme;
    @Size(max = 20)
    @Column(name = "sifra")
    private String sifra;
    @OneToMany(mappedBy = "trener")
    private List<Trening> treningList;

    public Trener() {
        treningList = new ArrayList<>();
    }

    public Trener(Integer trenerID) {
        this();
        this.trenerID = trenerID;
    }

    public Integer getTrenerID() {
        return trenerID;
    }

    public void setTrenerID(Integer trenerID) {
        this.trenerID = trenerID;
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

    public String getLicencaTrenera() {
        return licencaTrenera;
    }

    public void setLicencaTrenera(String licencaTrenera) {
        this.licencaTrenera = licencaTrenera;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @XmlTransient
    public List<Trening> getTreningList() {
        return treningList;
    }

    public void setTreningList(List<Trening> treningList) {
        this.treningList = treningList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trenerID != null ? trenerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trener)) {
            return false;
        }
        Trener other = (Trener) object;
        if ((this.trenerID == null && other.trenerID != null) || (this.trenerID != null && !this.trenerID.equals(other.trenerID))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return ime + " " + prezime;
//    }
    @Override
    public String toString() {
        return "Trener{" + "trenerID=" + trenerID + ", jmbg=" + jmbg + ", ime=" + ime + ", prezime=" + prezime + ", licencaTrenera=" + licencaTrenera + ", korisnickoIme=" + korisnickoIme + ", sifra=" + sifra + ", treningList=" + treningList + '}';
    }
    
    
}
