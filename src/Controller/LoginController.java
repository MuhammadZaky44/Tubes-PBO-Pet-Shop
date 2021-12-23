package Controller;

import DAO.UserDAO;
import Database.Koneksi;
import View.Dashboard;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import View.Login;

/**
 *
 * @author MZA
 */
public class LoginController {
    private UserDAO userDAO = new UserDAO(); 
    
    public void login(Login form) {
        String username = form.usernameField.getText();
        String password = form.passwordField.getText();

        ResultSet result = userDAO.cekAkun(username);        

        try {
            validasi(username, password);
            if (result.next()) {
                if (password.equals(result.getString("password"))) {
                    new Dashboard(result.getInt("id"), username).setVisible(true);
                    form.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Password anda salah!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Akun tidak ditemukan.");
            }
        } catch (Exception ex) {            
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
        public boolean validasi(String username, String password) {
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
