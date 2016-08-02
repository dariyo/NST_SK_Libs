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
public class DeoTreningaPK implements Serializable {
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "treningID")
    @JsonView(View.Normal.class)
    private int treningID;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "deotreningaID")
    @JsonView(View.Normal.class)
    private int deotreningaID;

    public DeoTreningaPK() {
    }

    public DeoTreningaPK(int treningID, int deotreningaID) {
        this.treningID = treningID;
        this.deotreningaID = deotreningaID;
    }

    public int getTreningID() {
        return treningID;
    }

    public void setTreningID(int treningID) {
        this.treningID = treningID;
    }

    public int getDeotreningaID() {
        return deotreningaID;
    }

    public void setDeotreningaID(int deotreningaID) {
        this.deotreningaID = deotreningaID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) treningID;
        hash += (int) deotreningaID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeoTreningaPK)) {
            return false;
        }
        DeoTreningaPK other = (DeoTreningaPK) object;
        if (this.treningID != other.treningID) {
            return false;
        }
        if (this.deotreningaID != other.deotreningaID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.DeoTreningaPK[ treningID=" + treningID + ", deotreningaID=" + deotreningaID + " ]";
    }
    
}
