/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.Koneksi;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MFI
 */
public class UserDAO implements DAOInterface<User> {
    Connection connection = Koneksi.getKoneksi();

    @Override
    public void insert(User user) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT INTO `user` (`id`, `username`, `password`) VALUES (?, ?, ?)");
            statement.setString(1, null);
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean isTaken(String username) {
        PreparedStatement statement = null;
        try {
            
            statement = connection.prepareStatement("SELECT * FROM user WHERE username like ?");
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            
            //jika data sudah pernah disimpan
            if (rs.next()) {
                statement.close();
                return true;
            //jika data belum pernah disimpan
            } else {                
                statement.close();
                return false;
            }            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void update(User object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> get(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
