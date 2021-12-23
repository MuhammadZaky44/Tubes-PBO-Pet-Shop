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
public class HistoryPembelian {

    private Integer id;
    private Date timestamp;
    private int harga;
    private User user;

    public HistoryPembelian() {
    }

    public HistoryPembelian(Integer id) {
        this.id = id;
    }

    public HistoryPembelian(Integer id, Date timestamp, int harga) {
        this.id = id;
        this.timestamp = timestamp;
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

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
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
        if (!(object instanceof HistoryPembelian)) {
            return false;
        }
        HistoryPembelian other = (HistoryPembelian) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.HistoryPembelian[ id=" + id + " ]";
    }
    
}
