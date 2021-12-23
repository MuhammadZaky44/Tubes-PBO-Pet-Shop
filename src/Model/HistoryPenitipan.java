/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author MFI
 */
public class HistoryPenitipan {

    private Integer id;
    private Date timestamp;
    private int lamaPenitipan;
    private int harga;
    private Hewan hewan;
    private User user;

    public HistoryPenitipan() {
    }

    public HistoryPenitipan(Integer id) {
        this.id = id;
    }

    public HistoryPenitipan(Integer id, Date timestamp, int lamaPenitipan, int harga) {
        this.id = id;
        this.timestamp = timestamp;
        this.lamaPenitipan = lamaPenitipan;
        this.harga = harga;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getLamaPenitipan() {
        return lamaPenitipan;
    }

    public void setLamaPenitipan(int lamaPenitipan) {
        this.lamaPenitipan = lamaPenitipan;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public Hewan getHewan() {
        return hewan;
    }

    public void setHewan(Hewan hewan) {
        this.hewan = hewan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoryPenitipan)) {
            return false;
        }
        HistoryPenitipan other = (HistoryPenitipan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.HistoryPenitipan[ id=" + id + " ]";
    }
    
}
