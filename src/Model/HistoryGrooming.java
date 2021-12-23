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
public class HistoryGrooming {

    private Integer id;
    private Date timestamp;
    private Date jam;
    private int harga;
    private Hewan hewan;
    private User user;

    public HistoryGrooming() {
    }

    public HistoryGrooming(Integer id) {
        this.id = id;
    }

    public HistoryGrooming(Integer id, Date timestamp, Date jam, int harga) {
        this.id = id;
        this.timestamp = timestamp;
        this.jam = jam;
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

    public Date getJam() {
        return jam;
    }

    public void setJam(Date jam) {
        this.jam = jam;
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
        if (!(object instanceof HistoryGrooming)) {
            return false;
        }
        HistoryGrooming other = (HistoryGrooming) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.HistoryGrooming[ id=" + id + " ]";
    }
    
}
