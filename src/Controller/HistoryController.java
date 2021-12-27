/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.GroomingDAO;
import DAO.PenitipanDAO;
import Model.Hewan;
import Model.HistoryGrooming;
import Model.HistoryPenitipan;
import View.History;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MFI
 */
public class HistoryController {
    private History historyView;
    private List<HistoryPenitipan> penitipanList;
    private List<HistoryGrooming> groomingList;
    private PenitipanDAO penitipanDAO;
    private GroomingDAO groomingDAO;
    private int idUser;
    private String[] penitipanHeader;
    private String[] groomingHeader;

    public HistoryController(History historyView, int idUser) {
        this.historyView = historyView;
        this.idUser = idUser;
        penitipanDAO = new PenitipanDAO(idUser);
        groomingDAO = new GroomingDAO(idUser);
        penitipanHeader = new String[]{"Timestamp", "ID Hewan", "Lama Penitipan", "Harga"};
        groomingHeader = new String[]{"Timestamp", "ID Hewan", "Jam Grooming", "Harga"};
    }
    
    public void renderTable() {
        penitipanList = penitipanDAO.getAll();
        groomingList = groomingDAO.getAll();
        
        DefaultTableModel penitipanTblModel = new DefaultTableModel(new Object[][]{}, penitipanHeader) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        Object[] penitipanData = new Object[penitipanHeader.length];
        for (HistoryPenitipan penitipan : penitipanList) {
            penitipanData[0] = penitipan.getTimestamp();
            penitipanData[1] = penitipan.getIdHewan();
            penitipanData[2] = penitipan.getLamaPenitipan();
            penitipanData[3] = penitipan.getHarga();
            penitipanTblModel.addRow(penitipanData);
        }
        
        historyView.penitipanTbl.setModel(penitipanTblModel);
        
        DefaultTableModel groomingTblModel = new DefaultTableModel(new Object[][]{}, groomingHeader) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        Object[] groomingData = new Object[groomingHeader.length];
        for (HistoryGrooming grooming : groomingList) {
            groomingData[0] = grooming.getTimestamp();
            groomingData[1] = grooming.getIdHewan();
            groomingData[2] = grooming.getDate();
            groomingData[3] = grooming.getHarga();
            groomingTblModel.addRow(groomingData);
        }
        
        historyView.groomingTbl.setModel(groomingTblModel);
    }
}
