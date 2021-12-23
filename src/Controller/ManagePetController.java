/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.HewanDAO;
import Model.Hewan;
import View.ManagePet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MFI
 */
public class ManagePetController {
    ManagePet managePetView;
    List<Hewan> hewanList;   
    private int idUser;
    HewanDAO hewanDAO;

    public ManagePetController(ManagePet managePetView, int idUser) {
        this.managePetView = managePetView;
        this.idUser = idUser;
        hewanDAO = new HewanDAO(idUser);
    }
    
    public void initialization() {
        hewanList = hewanDAO.getAll();
        
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Nama", "Tahun Lahir", "Jenis", "Breed"}) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        Object[] data = new Object[5];
        for (Hewan hewan : hewanList) {
            data[0] = hewan.getId();
            data[1] = hewan.getNama();
            data[2] = hewan.getTahunLahir();
            data[3] = hewan.getJenis();
            data[4] = hewan.getBreed();
            tblModel.addRow(data);
        }
        
        managePetView.petTbl.setModel(tblModel);
    }
}
