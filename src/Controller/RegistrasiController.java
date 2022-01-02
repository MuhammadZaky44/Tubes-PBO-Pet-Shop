/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import Model.User;
import View.Login;
import View.Registrasi;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author MFI
 */
public class RegistrasiController {
    private UserDAO userDAO = new UserDAO();
    private Registrasi registrasiView;

    public RegistrasiController(Registrasi registrasiView) {
        this.registrasiView = registrasiView;
    }
    
    public void registrasi() {
        String username = registrasiView.usernameField.getText();
        String password = registrasiView.passwordField.getText();
        String handphone = registrasiView.handphoneField.getText();
        String alamat = registrasiView.alamatField.getText();
        
        User user = new User(username, password, handphone, alamat);
        
        boolean isValid = validasi(username, password, handphone, alamat);
        if(isValid) {
            userDAO.insert(user);
            JOptionPane.showMessageDialog(null, "Registrasi berhasil.");
            registrasiView.dispose();
            new Login().setVisible(true);
        }
    }
    
    public boolean validasi(String username, String password, String handphone, String alamat) {
        if(username.equals("") ) {
            JOptionPane.showMessageDialog(null, "Mohon isi username anda.");
            return false;
        }
        
        if (userDAO.isTaken(username)) {
            JOptionPane.showMessageDialog(null, "Username sudah ada.");
            return false;
        }
        
        if(username.equals("") ) {
            JOptionPane.showMessageDialog(null, "Mohon isi username anda.");
            return false;
        }
        
        if( password.equals("") ) {
            JOptionPane.showMessageDialog(null, "Mohon isi password anda.");
            return false;
        }
        
        if( password.length() < 8 ) {
            JOptionPane.showMessageDialog(null, "Password minimal harus berisi 8 karakter!");
            return false;
        }
        
        if( handphone.equals("") ) {
            JOptionPane.showMessageDialog(null, "Mohon isi nomor handphone anda.");
            return false;           
        }
        
        if( alamat.equals("") ) {
           JOptionPane.showMessageDialog(null, "Mohon isi alamat anda.");
           return false;           
        }
        return true;
    }
}
