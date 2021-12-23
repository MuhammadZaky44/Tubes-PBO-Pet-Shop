/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.HewanDAO;
import Model.Hewan;
import View.Penitipan;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author DELL
 */
public class PenitipanController {
    Penitipan penitipanView;
    List<Hewan> hewanList;   
    private int idUser;
    HewanDAO hewanDAO;
    String[] header;
    
    public PenitipanController(Penitipan penitipanView, int idUser) {
        this.penitipanView = penitipanView;
        this.idUser = idUser;
        hewanDAO = new HewanDAO(idUser);
        header = new String[]{"Id", "Nama", "Tahun Lahir", "Jenis"};
    }
    
    public void renderTable() {
        hewanList = hewanDAO.getAll();
        
        DefaultListModel listModel = new DefaultListModel() {
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
            listModel.addElement(data[1]);
        }
        
        penitipanView.petlist.setModel(listModel);
    }
}
