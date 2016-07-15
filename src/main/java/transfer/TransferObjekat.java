package transfer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author probni
 * @param <T>
 */
@XmlRootElement
@JsonSerialize
public class TransferObjekat<T extends Object> {
    
    private T objekat;
    private int status;
    private String error;
    
    public final static int SUCCESS = 1;
    public final static int ERROR = -1;

    public TransferObjekat(T objekat, int status, String error) {
        this.objekat = objekat;
        this.status = status;
        this.error = error;
    }

    public TransferObjekat() {
    }

    public T getObjekat() {
        return objekat;
    }

    public void setObjekat(T objekat) {
        this.objekat = objekat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "TransferObjekat{" + "objekat=" + objekat + ", status=" + status + ", error=" + error + '}';
    }
}
