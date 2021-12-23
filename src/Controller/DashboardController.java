/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Dashboard;

/**
 *
 * @author MFI
 */
public class DashboardController {
    Dashboard form;

    public DashboardController(Dashboard form) {
        this.form = form;
    }
    
    public void initialization(String username) {
        form.welcomeLabel.setText("Selamat datang, " + username  + "!");
    }
}
