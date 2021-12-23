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
    
    public void registrasi(Registrasi form) {
        String username = form.usernameField.getText();
        String password = form.passwordField.getText();
        
        User user = new User(username, password);
        
        boolean isValid = validasi(username, password);
        if(isValid) {
            userDAO.insert(user);
            JOptionPane.showMessageDialog(null, "Registrasi berhasil.");
            form.dispose();
            new Login().setVisible(true);
        }
    }
    
    public boolean validasi(String username, String password) {
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
        
        return true;
    }
}
