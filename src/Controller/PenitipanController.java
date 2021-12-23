/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.HewanDAO;
import DAO.PenitipanDAO;
import Model.Hewan;
import Model.HistoryPenitipan;
import View.Penitipan;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class PenitipanController {
    Penitipan penitipanView;
    List<Hewan> hewanList;   
    private int idUser;
    HewanDAO hewanDAO;
    PenitipanDAO penitipanDAO;
    String[] header;
    
    public PenitipanController(Penitipan penitipanView, int idUser) {
        this.penitipanView = penitipanView;
        this.idUser = idUser;
        hewanDAO = new HewanDAO(idUser);
        penitipanDAO = new PenitipanDAO(idUser);
        header = new String[]{"Id", "Nama"};
    }
    
    public void renderTable() {
        hewanList = hewanDAO.getAll();
        
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        Object[] data = new Object[header.length];
        for (Hewan hewan : hewanList) {
            data[0] = hewan.getId();
            data[1] = hewan.getNama();
            tblModel.addRow(data);
        }
        
        penitipanView.petTbl.setModel(tblModel);
    }
    
    public void konfirmasi(int idHewan) {        
        HistoryPenitipan penitipan = new HistoryPenitipan();
        
        int lama = Integer.parseInt(penitipanView.lamaField.getText());
        int harga = lama * 25000;
        
        penitipan.setIdHewan(idHewan);
        penitipan.setLamaPenitipan(lama);
        penitipan.setHarga(lama * 25000);
        
        int n = JOptionPane.showConfirmDialog(
                            penitipanView, String.format("Apakah anda ingin menitipkan %s selama %s dengan biaya %s?", idHewan, lama, harga),
                            "An Inane Question",
                            JOptionPane.YES_NO_OPTION);
        
        if (n == JOptionPane.YES_OPTION) {
            penitipanDAO.insert(penitipan);
        } else if (n == JOptionPane.NO_OPTION) {
            
        } else {
            
        }
                
    }
}
