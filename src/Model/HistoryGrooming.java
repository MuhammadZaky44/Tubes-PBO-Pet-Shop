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
    private String jam;
    private String menit;
    private int harga;
    private int idHewan;
    private int idUser;
    private String date;

    public HistoryGrooming() {
    }

    public HistoryGrooming(Integer id) {
        this.id = id;
    }

    public HistoryGrooming(Integer id, Date timestamp, String date, int harga) {
        this.id = id;
        this.timestamp = timestamp;
        this.date = date;
        this.harga = harga;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }
    
    public void setMenit(String menit) {
        this.menit = menit;
    }
    
    public String getMenit() {
        return menit;
    }
    
    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    public int getIdHewan() {
        return idHewan;
    }

    public void setIdHewan(int idHewan) {
        this.idHewan = idHewan;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

}
