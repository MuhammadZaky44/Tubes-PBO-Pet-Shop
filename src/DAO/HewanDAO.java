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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Hewan object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                list.add(new Hewan(rs.getInt("id"), rs.getString("nama"), rs.getInt("tahun_lahir"), rs.getString("jenis"), rs.getString("breed")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
