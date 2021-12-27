/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.Koneksi;
import Model.Hewan;
import Model.HistoryPenitipan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MFI
 */
public class PenitipanDAO implements DAOInterface<HistoryPenitipan> {
    Connection connection = Koneksi.getKoneksi();
    private int idUser;

    public PenitipanDAO(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public void insert(HistoryPenitipan object) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO `history_penitipan` (`id`, `id_user`, `id_hewan`, `timestamp`, `lama_penitipan`, `harga`) VALUES (NULL, ?, ?, current_timestamp(), ?, ?)");
            statement.setInt(1, idUser);
            statement.setInt(2, object.getIdHewan());
            statement.setInt(3, object.getLamaPenitipan());
            statement.setInt(4, object.getHarga());
            statement.executeUpdate();
            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(HistoryPenitipan object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HistoryPenitipan> get(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HistoryPenitipan> getAll() {
        List<HistoryPenitipan> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM `history_penitipan` WHERE id_user=?");
            statement.setInt(1, idUser);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                HistoryPenitipan penitipan = new HistoryPenitipan(rs.getInt("id"), rs.getString("timestamp"), rs.getInt("lama_hari"), rs.getInt("harga"));
                penitipan.setIdUser(rs.getInt("id_user"));
                penitipan.setIdUser(rs.getInt("id_hewan"));
                list.add(penitipan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
