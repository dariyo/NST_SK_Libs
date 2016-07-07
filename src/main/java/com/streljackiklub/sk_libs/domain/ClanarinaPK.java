/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.streljackiklub.sk_libs.domain;

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
public class ClanarinaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "clanID")
    private int clanID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clanarinaID")
    private int clanarinaID;

    public ClanarinaPK() {
        clanID = -1;
        clanarinaID = -3;
    }

    public ClanarinaPK(int clanID, int clanarinaID) {
        this.clanID = clanID;
        this.clanarinaID = clanarinaID;
    }

    public int getClanID() {
        return clanID;
    }

    public void setClanID(int clanID) {
        this.clanID = clanID;
    }

    public int getClanarinaID() {
        return clanarinaID;
    }

    public void setClanarinaID(int clanarinaID) {
        this.clanarinaID = clanarinaID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) clanID;
        hash += (int) clanarinaID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClanarinaPK)) {
            return false;
        }
        ClanarinaPK other = (ClanarinaPK) object;
        if (this.clanID != other.clanID) {
            return false;
        }
        if (this.clanarinaID != other.clanarinaID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.ClanarinaPK[ clanID=" + clanID + ", clanarinaID=" + clanarinaID + " ]";
    }
    
}
