/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasi_resto;


import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class daftar_barang extends javax.swing.JFrame {
    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    /**
     * Creates new form daftar_barang
     */
    public daftar_barang() {
        initComponents();
        btnInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasi_resto/icons/input.png")));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasi_resto/icons/update.png")));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasi_resto/icons/delete.png")));
        btnMenuRegistrasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasi_resto/icons/registration.png")));
        btnTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasi_resto/icons/transaction.png")));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasi_resto/icons/logout.png")));
        btnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/aplikasi_resto/icons/search.png")));

        k.connect();
        refreshTable();
        labelUsername.setText("Halo, " + GlobalData.currentUsername + "!");
    }
    
    class barang extends daftar_barang{
        int id_barang, harga;
        String nama_barang, status;
        
        public barang(){
            this.nama_barang = textNamaBarang.getText();
            this.harga = Integer.parseInt(textHargaBarang.getText());
            this.status = comboStatusBarang.getSelectedItem().toString();
        }
    }
    
    public void refreshTable(){
        model = new DefaultTableModel();
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga");
        model.addColumn("Status Barang");
        tableBarang.setModel(model);
        try {
            this.stat = k.getCon().prepareStatement("select * from barang");
            this.rs = this.stat.executeQuery();
            while (rs.next()){
                Object[] data={
                    rs.getInt("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getInt("harga"),
                    rs.getString("status")
                };
                model.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        textIDBarang.setText("");
        textNamaBarang.setText("");
        textHargaBarang.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textNamaBarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textIDBarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textHargaBarang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboStatusBarang = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBarang = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnInput = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnMenuRegistrasi = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnTransaksi = new javax.swing.JButton();
        textCariBarang = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        labelUsername = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DAFTAR BARANG");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("ID Barang");

        textNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNamaBarangActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Harga");

        textIDBarang.setEnabled(false);
        textIDBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIDBarangActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Nama Barang");

        textHargaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHargaBarangActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Status Barang");

        comboStatusBarang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comboStatusBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TERSEDIA", "HABIS" }));

        tableBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableBarang);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnInput.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInput.setText("INPUT");
        btnInput.setEnabled(false);
        btnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnMenuRegistrasi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMenuRegistrasi.setText("MENU REGISTRASI");
        btnMenuRegistrasi.setEnabled(false);
        btnMenuRegistrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuRegistrasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInput)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnMenuRegistrasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInput)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnMenuRegistrasi))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogout.setText("LOGOUT");
        btnLogout.setEnabled(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnTransaksi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTransaksi.setText("MENU TRANSAKSI");
        btnTransaksi.setEnabled(false);
        btnTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiActionPerformed(evt);
            }
        });

        textCariBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCariBarangActionPerformed(evt);
            }
        });

        btnCari.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        labelUsername.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textIDBarang)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(comboStatusBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(textCariBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(textHargaBarang, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textNamaBarang, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(29, 29, 29))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnTransaksi)
                        .addGap(87, 87, 87)
                        .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLogout)
                        .addComponent(btnTransaksi))
                    .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textIDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textCariBarang)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboStatusBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCari)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNamaBarangActionPerformed

    private void textIDBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIDBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIDBarangActionPerformed

    private void textHargaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHargaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHargaBarangActionPerformed

    private void btnInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputActionPerformed
        // TODO add your handling code here:
        try {
            barang b = new barang();
            this.stat = k.getCon().prepareStatement("insert into barang values(?,?,?,?)");
            stat.setInt(1, 0);
            stat.setString(2, b.nama_barang);
            stat.setInt(3, b.harga);
            stat.setString(4, b.status);
            stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnInputActionPerformed

    private void tableBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBarangMouseClicked
        // TODO add your handling code here:
        textIDBarang.setText(model.getValueAt(tableBarang.getSelectedRow(), 0).toString());
        textNamaBarang.setText(model.getValueAt(tableBarang.getSelectedRow(), 1).toString());
        textHargaBarang.setText(model.getValueAt(tableBarang.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tableBarangMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            barang b = new barang();
            this.stat = k.getCon().prepareStatement("update barang set nama_barang=?,"
                     + "harga=?,status=? where id_barang=?");
            stat.setString(1, b.nama_barang);
            stat.setInt(2, b.harga);
            stat.setString(3, b.status);
            stat.setInt(4, Integer.parseInt(textIDBarang.getText()));
            stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            this.stat = k.getCon().prepareStatement("delete from barang where id_barang=?");
            stat.setInt(1, Integer.parseInt(textIDBarang.getText()));
            stat.executeUpdate();refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnMenuRegistrasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuRegistrasiActionPerformed
        // TODO add your handling code here:
        Menu_Registrasi reg = new Menu_Registrasi(); 
        reg.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuRegistrasiActionPerformed

    private void btnTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiActionPerformed
        // TODO add your handling code here:
        Menu_Transaksi1 tran = new Menu_Transaksi1();
        tran.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTransaksiActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        Login l = new Login();
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        String keyword = textCariBarang.getText();
    model = new DefaultTableModel();
    model.addColumn("ID Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Harga");
    model.addColumn("Status Barang");
    tableBarang.setModel(model);

    try {
        this.stat = k.getCon().prepareStatement(
            "SELECT * FROM barang WHERE nama_barang LIKE ?"
        );
        stat.setString(1, "%" + keyword + "%");
        this.rs = stat.executeQuery();
        while (rs.next()) {
            Object[] data = {
                rs.getInt("id_barang"),
                rs.getString("nama_barang"),
                rs.getInt("harga"),
                rs.getString("status")
            };
            model.addRow(data);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    }//GEN-LAST:event_btnCariActionPerformed

    private void textCariBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCariBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCariBarangActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(daftar_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(daftar_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(daftar_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(daftar_barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new daftar_barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnInput;
    public javax.swing.JButton btnLogout;
    public javax.swing.JButton btnMenuRegistrasi;
    public javax.swing.JButton btnTransaksi;
    public javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboStatusBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JTable tableBarang;
    private javax.swing.JTextField textCariBarang;
    private javax.swing.JTextField textHargaBarang;
    public javax.swing.JTextField textIDBarang;
    private javax.swing.JTextField textNamaBarang;
    // End of variables declaration//GEN-END:variables
}
