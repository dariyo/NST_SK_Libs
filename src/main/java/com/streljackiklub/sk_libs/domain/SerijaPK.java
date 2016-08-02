/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.streljackiklub.sk_libs.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.streljackiklub.sk_libs.json_view.View;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Dario
 */
@Embeddable
public class SerijaPK implements Serializable {
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "treningID")
    @JsonView(View.Normal.class)
    private int treningID;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "deoTreningaID")
    @JsonView(View.Normal.class)
    private int deoTreningaID;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "serijaID")
    @JsonView(View.Normal.class)
    private int serijaID;

    public SerijaPK() {
    }

    public SerijaPK(int treningID, int deoTreningaID, int serijaID) {
        this.treningID = treningID;
        this.deoTreningaID = deoTreningaID;
        this.serijaID = serijaID;
    }

    public int getTreningID() {
        return treningID;
    }

    public void setTreningID(int treningID) {
        this.treningID = treningID;
    }

    public int getDeoTreningaID() {
        return deoTreningaID;
    }

    public void setDeoTreningaID(int deoTreningaID) {
        this.deoTreningaID = deoTreningaID;
    }

    public int getSerijaID() {
        return serijaID;
    }

    public void setSerijaID(int serijaID) {
        this.serijaID = serijaID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) treningID;
        hash += (int) deoTreningaID;
        hash += (int) serijaID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SerijaPK)) {
            return false;
        }
        SerijaPK other = (SerijaPK) object;
        if (this.treningID != other.treningID) {
            return false;
        }
        if (this.deoTreningaID != other.deoTreningaID) {
            return false;
        }
        if (this.serijaID != other.serijaID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.SerijaPK[ treningID=" + treningID + ", deoTreningaID=" + deoTreningaID + ", serijaID=" + serijaID + " ]";
    }
    
}
