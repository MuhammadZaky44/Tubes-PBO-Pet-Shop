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
    private String timestamp;
    private int lamaPenitipan;
    private int harga;
    private int idHewan;
    private int idUser;

    public HistoryPenitipan() {
    }

    public HistoryPenitipan(Integer id) {
        this.id = id;
    }

    public HistoryPenitipan(Integer id, String timestamp, int lamaPenitipan, int harga) {
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
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
