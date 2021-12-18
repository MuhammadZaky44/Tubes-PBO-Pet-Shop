/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "hewan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hewan.findAll", query = "SELECT h FROM Hewan h")
    , @NamedQuery(name = "Hewan.findById", query = "SELECT h FROM Hewan h WHERE h.id = :id")
    , @NamedQuery(name = "Hewan.findByNama", query = "SELECT h FROM Hewan h WHERE h.nama = :nama")
    , @NamedQuery(name = "Hewan.findByTahunLahir", query = "SELECT h FROM Hewan h WHERE h.tahunLahir = :tahunLahir")
    , @NamedQuery(name = "Hewan.findByJenis", query = "SELECT h FROM Hewan h WHERE h.jenis = :jenis")
    , @NamedQuery(name = "Hewan.findByBreed", query = "SELECT h FROM Hewan h WHERE h.breed = :breed")})
public class Hewan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Column(name = "tahun_lahir")
    private int tahunLahir;
    @Basic(optional = false)
    @Column(name = "jenis")
    private String jenis;
    @Basic(optional = false)
    @Column(name = "breed")
    private String breed;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHewan")
    private Collection<Penitipan> penitipanCollection;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User idUser;

    public Hewan() {
    }

    public Hewan(Integer id) {
        this.id = id;
    }

    public Hewan(Integer id, String nama, int tahunLahir, String jenis, String breed) {
        this.id = id;
        this.nama = nama;
        this.tahunLahir = tahunLahir;
        this.jenis = jenis;
        this.breed = breed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getTahunLahir() {
        return tahunLahir;
    }

    public void setTahunLahir(int tahunLahir) {
        this.tahunLahir = tahunLahir;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @XmlTransient
    public Collection<Penitipan> getPenitipanCollection() {
        return penitipanCollection;
    }

    public void setPenitipanCollection(Collection<Penitipan> penitipanCollection) {
        this.penitipanCollection = penitipanCollection;
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
        if (!(object instanceof Hewan)) {
            return false;
        }
        Hewan other = (Hewan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Hewan[ id=" + id + " ]";
    }
    
}
