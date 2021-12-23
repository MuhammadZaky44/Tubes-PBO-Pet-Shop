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
    String[] header;

    public ManagePetController(ManagePet managePetView, int idUser) {
        this.managePetView = managePetView;
        this.idUser = idUser;
        hewanDAO = new HewanDAO(idUser);
        header = new String[]{"Id", "Nama", "Tahun Lahir", "Jenis"};
    }
    
    public void renderTable() {
        hewanList = hewanDAO.getAll();
        
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Nama", "Tahun Lahir", "Jenis"}) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        Object[] data = new Object[header.length];
        for (Hewan hewan : hewanList) {
            data[0] = hewan.getId();
            data[1] = hewan.getNama();
            data[2] = hewan.getTahunLahir();
            data[3] = hewan.getJenis();
            tblModel.addRow(data);
        }
        
        managePetView.petTbl.setModel(tblModel);
    }
    
    public void insert() {
        Hewan hewan = new Hewan(idUser, managePetView.namaField.getText(), Integer.parseInt(managePetView.tahunLahirField.getText()), (String) managePetView.jenisComboBox.getSelectedItem());
        hewanDAO.insert(hewan);
    }
    
    public void update() {
        
    }
    
    public void delete() {
        
    }
}
