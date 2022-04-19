/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.BanDAO;
import Controller.CTHoaDonDAO;
import Controller.HoaDonDAO;
import Controller.LoaiHangDAO;
import Controller.TaiKhoanDAO;
import Helper.ToanCuc;
import Helper.DatabaseHelper;
import Model.Ban;
import Model.LoaiHang;
import Model.HoaDon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author huyparody
 */
public class frmQuanLyThucDon extends javax.swing.JFrame {

        /**
         * Creates new form frmQuanLyThucDon
         */
        String idTable ="";
        DefaultComboBoxModel<String> comboBoxModel;
        DefaultTableModel tableModelTables;
        DefaultTableModel tableModelDrinks;
        int totalPrice = 0;
        String dataTranfer;

        public frmQuanLyThucDon() {
                initComponents();
                ToanCuc tc = new ToanCuc();
                txtDisplay.setText("Xin chào nhân viên: " +tc.getTen());
                tableModelTables = new DefaultTableModel();
                tableModelTables.addColumn("STT");
                tableModelTables.addColumn("Tên bàn");
                tableModelTables.addColumn("Trạng thái");
                tblTables.setModel(tableModelTables);
                displayTables();

                tableModelDrinks = new DefaultTableModel();
                tableModelDrinks.addColumn("STT");
                tableModelDrinks.addColumn("Tên đồ uống");
                tableModelDrinks.addColumn("Giá");
                tableModelDrinks.addColumn("Số lượng");
                tableModelDrinks.addColumn("Thành tiền");
                tblOrder.setModel(tableModelDrinks);

                comboBoxModel = new DefaultComboBoxModel<>();
                cboDrinks.setSelectedIndex(-1);
                comboBoxModel.setSelectedItem("Chọn loại đồ uống");
                
                cboDrinks.setModel(comboBoxModel);
                loadDrinks();
        }



        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTables = new javax.swing.JTable();
        cboDrinks = new javax.swing.JComboBox();
        btnAdd = new javax.swing.JButton();
        spnAmount = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        btnPay = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        btnHome = new javax.swing.JButton();
        txtDisplay = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lý bán hàng");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GiaoDien/Icon/icons8-restaurant-menu-50.png"))); // NOI18N
        jLabel1.setText("Quản lý bán hàng");

        tblTables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblTables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTables);

        cboDrinks.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboDrinks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDrinksActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GiaoDien/Icon/Plus_50px.png"))); // NOI18N
        btnAdd.setText("Thêm đồ uống");
        btnAdd.setEnabled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        spnAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spnAmount.setValue(1);

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblOrder);

        btnPay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GiaoDien/Icon/Cash in Hand_50px.png"))); // NOI18N
        btnPay.setText("Thanh toán");
        btnPay.setEnabled(false);
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tổng tiền");

        txtTotalPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTotalPrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalPrice.setText("0");
        txtTotalPrice.setEnabled(false);

        btnHome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GiaoDien/Icon/Go Back_50px.png"))); // NOI18N
        btnHome.setText("Quay lại");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        txtDisplay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDisplay.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPay)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(229, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(txtDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
            // TODO add your handling code here:
            int MaHD = HoaDonDAO.getInstance().GetUncheckInvoiceByTableId(Integer.parseInt(idTable));
            LoaiHang drinks = (LoaiHang) cboDrinks.getSelectedItem();

            if (MaHD == -1) {
                    HoaDonDAO.getInstance().Insert(Integer.parseInt(idTable), Integer.parseInt(TaiKhoanDAO.getInstance().getTaiKhoan().getMaNV()));
                    CTHoaDonDAO.getInstance().Insert(drinks.getMaLH(), HoaDonDAO.getInstance().GetMaxIdInvoice(),
                            Integer.parseInt(spnAmount.getValue().toString()));
            } else {
                    CTHoaDonDAO.getInstance().Insert(drinks.getMaLH(), MaHD, Integer.parseInt(spnAmount.getValue().toString()));
            }
            CTHoaDonDAO dao = new CTHoaDonDAO();
            dao.updateStatus(idTable);
                    displayTables();
                    //displayTableDrinks();
                    btnPay.setEnabled(true);
                    cboDrinks.setSelectedIndex(0);
            
    }//GEN-LAST:event_btnAddActionPerformed

    private void cboDrinksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDrinksActionPerformed
            // TODO add your handling code here:

    }//GEN-LAST:event_cboDrinksActionPerformed

    private void tblTablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablesMouseClicked
            // TODO add your handling code here:
            int row = tblTables.getSelectedRow();
            btnAdd.setEnabled(true);
            if ((tblTables.getValueAt(row, 2) + "").equals("Đã đặt")) {
                    btnPay.setEnabled(true);
            } else {
                    btnPay.setEnabled(false);
            }
            List<Ban> listTable = BanDAO.getInstance().listBan();
            Integer.parseInt(listTable.get(row).getMaBan());
            idTable = listTable.get(row).getMaBan();
            //displayTableDrinks();
    }//GEN-LAST:event_tblTablesMouseClicked

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
//            try {
//                    // TODO add your handling code here:
//                    int invoiceId = InvoicesDAO.getInstance().GetUncheckInvoiceByTableId(idTable);
//                    InvoicesDAO.getInstance().Update(invoiceId, totalPrice);
//                    Connection con = DBUtility.openConnection();
//                    PreparedStatement pstmt = con.prepareStatement("update tables set status=0 where ID=?");
//                    pstmt.setInt(1, idTable);
//                    pstmt.executeUpdate();
//                    displayTables();
//                    displayTableDrinks();
//            } catch (SQLException ex) {
//                    Logger.getLogger(frmQuanLyThucDon.class.getName()).log(Level.SEVERE, null, ex);
//            }
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
            
            dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomeActionPerformed

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
                                if ("Windows".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(frmQuanLyThucDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(frmQuanLyThucDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(frmQuanLyThucDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(frmQuanLyThucDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new frmQuanLyThucDon().setVisible(true);
                        }
                });
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnPay;
    private javax.swing.JComboBox cboDrinks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spnAmount;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTable tblTables;
    private javax.swing.JLabel txtDisplay;
    private javax.swing.JTextField txtTotalPrice;
    // End of variables declaration//GEN-END:variables

        private void displayTables() {
                tableModelTables.setRowCount(0);
                List<Ban> listTable = BanDAO.getInstance().listBan();
                for (int i = 0; i < listTable.size(); i++) {
                        Ban tables = listTable.get(i);
                        Object[] dt = {i + 1, tables.getSoBan(), tables.getTinhTrang()};
                        tableModelTables.addRow(dt);
                }
        }

        private void displayTableDrinks() {
//                tableModelDrinks.setRowCount(0);
//
//                List<Menu> listMenu = MenuDAO.getInstance().GetListMenuByTableId(idTable);
//                for (int i = 0; i < listMenu.size(); i++) {
//                        Menu menu = listMenu.get(i);
//                        Object[] dt = {i + 1, menu.getDrinkName(), menu.getPrice(), menu.getCount(), menu.getTotalPrice()};
//                        totalPrice += menu.getTotalPrice();
//                        tableModelDrinks.addRow(dt);
//                }
//                txtTotalPrice.setText(totalPrice + "");
       }

        private void loadDrinks() {
            List<String>  list = new ArrayList<>();
            LoaiHangDAO dao = new LoaiHangDAO();
            list = dao.listTenLoaiHang();
            for(String drinks : list){
                comboBoxModel.addElement(drinks);
            }
        }
}
