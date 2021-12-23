/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.Koneksi;
import Model.Hewan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MFI
 */
public class HewanDAO implements DAOInterface<Hewan> {
    Connection connection = Koneksi.getKoneksi();
    private int idUser;

    public HewanDAO(int username) {
        this.idUser = username;
    }

    @Override
    public void insert(Hewan object) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO `hewan` (`id`, `id_user`, `nama`, `tahun_lahir`, `jenis`) VALUES (NULL, ?, ?, ?, ?)");
            statement.setInt(1, idUser);
            statement.setString(2, object.getNama());
            statement.setInt(3, object.getTahunLahir());
            statement.setString(4, object.getJenis());
            statement.executeUpdate();
            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Hewan object) {
//        PreparedStatement statement = null;
//        try {
//            statement = connection.prepareStatement(CARI);
//            statement.setString(1, object.getKode());
//            ResultSet rs = statement.executeQuery();
//            if (rs.next()) //jika data sudah pernah disimpan
//            {
//                statement = connection.prepareStatement(UPDATE);
//                statement.setString(1, object.getNama());
//                statement.setString(2, object.getAlamat());
//                statement.setString(3, object.getUmur());
//                statement.setString(4, object.getTlp());
//                statement.setString(5, object.getKode());
//                statement.executeUpdate();                    
//                JOptionPane.showMessageDialog(null, "Data berhasil di ubah!");                
//            } else {    //jika data belum pernah disimpan     
//                JOptionPane.showMessageDialog(null, "Kode barang tersebut belum pernah di simpan!");    
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                statement.close();
//            } catch (SQLException ex) {
//                Logger.getLogger(DAO_Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Hewan> get(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Hewan> getAll() {
        List<Hewan> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM hewan WHERE id_user=?");
            statement.setInt(1, idUser);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                list.add(new Hewan(rs.getInt("id"), rs.getString("nama"), rs.getInt("tahun_lahir"), rs.getString("jenis")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
