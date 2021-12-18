/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "penitipan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Penitipan.findAll", query = "SELECT p FROM Penitipan p")
    , @NamedQuery(name = "Penitipan.findById", query = "SELECT p FROM Penitipan p WHERE p.id = :id")
    , @NamedQuery(name = "Penitipan.findByLamaPenitipan", query = "SELECT p FROM Penitipan p WHERE p.lamaPenitipan = :lamaPenitipan")
    , @NamedQuery(name = "Penitipan.findByHarga", query = "SELECT p FROM Penitipan p WHERE p.harga = :harga")})
public class Penitipan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "lama_penitipan")
    private int lamaPenitipan;
    @Basic(optional = false)
    @Column(name = "harga")
    private int harga;
    @JoinColumn(name = "id_hewan", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Hewan idHewan;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idUser;

    public Penitipan() {
    }

    public Penitipan(Integer id) {
        this.id = id;
    }

    public Penitipan(Integer id, int lamaPenitipan, int harga) {
        this.id = id;
        this.lamaPenitipan = lamaPenitipan;
        this.harga = harga;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Hewan getIdHewan() {
        return idHewan;
    }

    public void setIdHewan(Hewan idHewan) {
        this.idHewan = idHewan;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
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
        if (!(object instanceof Penitipan)) {
            return false;
        }
        Penitipan other = (Penitipan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Penitipan[ id=" + id + " ]";
    }
    
}
