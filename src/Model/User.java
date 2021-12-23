/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author MFI
 */
public class User {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private List<HistoryGrooming> historyGroomingList;
    private List<HistoryPembelian> historyPembelianList;
    private List<HistoryPenitipan> historyPenitipanList;
    private List<Hewan> hewanList;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<HistoryGrooming> getHistoryGroomingList() {
        return historyGroomingList;
    }

    public void setHistoryGroomingList(List<HistoryGrooming> historyGroomingList) {
        this.historyGroomingList = historyGroomingList;
    }

    public List<HistoryPembelian> getHistoryPembelianList() {
        return historyPembelianList;
    }

    public void setHistoryPembelianList(List<HistoryPembelian> historyPembelianList) {
        this.historyPembelianList = historyPembelianList;
    }

    public List<HistoryPenitipan> getHistoryPenitipanList() {
        return historyPenitipanList;
    }

    public void setHistoryPenitipanList(List<HistoryPenitipan> historyPenitipanList) {
        this.historyPenitipanList = historyPenitipanList;
    }

    public List<Hewan> getHewanList() {
        return hewanList;
    }

    public void setHewanList(List<Hewan> hewanList) {
        this.hewanList = hewanList;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.User[ id=" + id + " ]";
    }
    
}
