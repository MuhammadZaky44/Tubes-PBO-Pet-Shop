package View;

import Controller.DashboardController;


public class Dashboard extends javax.swing.JFrame {

    static int idUser;
    static String username;
    DashboardController controller = new DashboardController(this);

    /**
     * Creates new form Dashboard
     * @param idUser
     */
    public Dashboard(int idUser, String username) {
        initComponents();
        this.idUser = idUser;
        this.username = username;
        controller.initialization(username);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        managePetBtn = new javax.swing.JButton();
        historyBtn = new javax.swing.JButton();
        penitipanBtn = new javax.swing.JButton();
        groomingBtn = new javax.swing.JButton();
        beliBarangBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        welcomeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        welcomeLabel.setText("Selamat Datang, x!");

        managePetBtn.setText("Manage Pet");
        managePetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePetBtnActionPerformed(evt);
            }
        });

        historyBtn.setText("Lihat History");
        historyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyBtnActionPerformed(evt);
            }
        });

        penitipanBtn.setText("Penitipan");
        penitipanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penitipanBtnActionPerformed(evt);
            }
        });

        groomingBtn.setText("Grooming");
        groomingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groomingBtnActionPerformed(evt);
            }
        });

        beliBarangBtn.setText("Beli Alat/Barang");
        beliBarangBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beliBarangBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(welcomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(managePetBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(historyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(penitipanBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(groomingBtn)
                        .addGap(31, 31, 31)
                        .addComponent(beliBarangBtn)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(managePetBtn)
                    .addComponent(welcomeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyBtn)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(penitipanBtn)
                    .addComponent(groomingBtn)
                    .addComponent(beliBarangBtn))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void penitipanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penitipanBtnActionPerformed
        new Penitipan(this.idUser).setVisible(true);
    }//GEN-LAST:event_penitipanBtnActionPerformed

    private void managePetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePetBtnActionPerformed
        // TODO add your handling code here:
        new ManagePet(this.idUser).setVisible(true);
    }//GEN-LAST:event_managePetBtnActionPerformed

    private void historyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBtnActionPerformed
        // TODO add your handling code here:
        new History().setVisible(true);
    }//GEN-LAST:event_historyBtnActionPerformed

    private void groomingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groomingBtnActionPerformed
        new Grooming(this.idUser).setVisible(true);
    }//GEN-LAST:event_groomingBtnActionPerformed

    private void beliBarangBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliBarangBtnActionPerformed
        new Pembelian().setVisible(true);
    }//GEN-LAST:event_beliBarangBtnActionPerformed

    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard(idUser, username).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton beliBarangBtn;
    private javax.swing.JButton groomingBtn;
    private javax.swing.JButton historyBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton managePetBtn;
    private javax.swing.JButton penitipanBtn;
    public javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
