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
import Controller.MenuDAO;
import Controller.TaiKhoanDAO;
import Controller.NhanVienDAO;
import Helper.ToanCuc;
import Model.Ban;
import Model.LoaiHang;
import Model.HoaDon;
import Model.Menu;
import Model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author huyparody
 */
public class frmQuanLyThucDon extends javax.swing.JFrame {

        /**
         * Creates new form frmQuanLyThucDon
         */
        int idTable = -1;
        
//      DefaultComboBoxModel<LoaiHang> comboBoxModel;
//      DefaultComboBoxModel<NhanVien> comboBoxModel1;

        
        DefaultTableModel tableModelTables;
        DefaultTableModel tableModelDrinks;
        int totalPrice = 0;

        public frmQuanLyThucDon() 
        {
                initComponents();
                ToanCuc tc = new ToanCuc();
                txtDisplay.setText("Xin chào nhân viên: " +tc.getTen());
                tableModelTables = new DefaultTableModel();
                tableModelTables.addColumn("Mã Bàn");
                tableModelTables.addColumn("Số bàn");
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

                loadDrinks();
                loadNhanVien();

//                comboBoxModel = new DefaultComboBoxModel<>();
//                LoaiHang mChon = new LoaiHang(-1, "---- Chọn đồ uống ----");
//                comboBoxModel.addElement(mChon);
//                cboDrinks.setModel(comboBoxModel);
//                loadDrinks();
//                
//                comboBoxModel1 = new DefaultComboBoxModel<>();
//                NhanVien nChon = new NhanVien(-1, "---- Chọn nhân viên ----");
//                comboBoxModel1.addElement(nChon);
//                cboNhanVien.setModel(comboBoxModel1);
//                loadNhanVien();
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
        cboNhanVien = new javax.swing.JComboBox<>();
        btnSua = new javax.swing.JButton();

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
        txtTotalPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPriceActionPerformed(evt);
            }
        });

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

        cboNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNhanVien.setSelectedIndex(-1);
        cboNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNhanVienActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GiaoDien/Icon/Plus_50px.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setEnabled(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(txtDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155)
                        .addComponent(btnPay)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(cboDrinks, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spnAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAdd)
                                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(13, 13, 13)
                                .addComponent(btnPay)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
            // TODO add your handling code here:
            
            int MaHD = HoaDonDAO.getInstance().GetUncheckInvoiceByTableId(idTable);
            LoaiHang drinks = (LoaiHang) cboDrinks.getSelectedItem();
            NhanVien nv = (NhanVien) cboNhanVien.getSelectedItem();

            if (MaHD == -1) {
                    HoaDonDAO.getInstance().Insert(idTable , nv.getMaNV());
                    CTHoaDonDAO.getInstance().Insert(HoaDonDAO.getInstance().GetMaxIdInvoice(),drinks.getMaLH(), 
                            Integer.parseInt(spnAmount.getValue().toString()));
            } else {
                    CTHoaDonDAO.getInstance().Insert(MaHD,drinks.getMaLH(),Integer.parseInt(spnAmount.getValue().toString()));
                    
            }
            Connection con = Helper.DatabaseHelper.getDBConnect();
            PreparedStatement pstmt;
            try {
                    pstmt = con.prepareStatement("update Ban set tinhtrang= 1 where MaBan=?");
                    pstmt.setInt(1, idTable);
                    pstmt.executeUpdate();
                    displayTables();
                    displayTableDrinks();
                    btnPay.setEnabled(true);
                    btnSua.setEnabled(true);
                    cboDrinks.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(rootPane, "Thêm đồ uống thành công!!.");
            } catch (SQLException ex) {
                    Logger.getLogger(frmQuanLyThucDon.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }//GEN-LAST:event_btnAddActionPerformed

    private void cboDrinksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDrinksActionPerformed
            // TODO add your handling code here:
            
            
    }//GEN-LAST:event_cboDrinksActionPerformed

    private void tblTablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablesMouseClicked
            // TODO add your handling code here:
            int row = tblTables.getSelectedRow();
            btnAdd.setEnabled(true);
            btnSua.setEnabled(true);
            if ((tblTables.getValueAt(row, 2) + "").equals("Đã đặt")) {
                    btnPay.setEnabled(true);
            } else {
                    btnPay.setEnabled(false);
            }
            List<Ban> listTable = BanDAO.getInstance().listBan();
            idTable = listTable.get(row).getMaBan();
            displayTableDrinks();
    }//GEN-LAST:event_tblTablesMouseClicked

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
            try {
                    // TODO add your handling code here:
                    int invoiceId = HoaDonDAO.getInstance().GetUncheckInvoiceByTableId(idTable);
                    HoaDonDAO.getInstance().Update(invoiceId, Integer.parseInt(txtTotalPrice.getText().toString()));
                    JOptionPane.showMessageDialog(rootPane,"Tổng hóa đơn: " + txtTotalPrice.getText());
                    Connection con = Helper.DatabaseHelper.getDBConnect();
                    PreparedStatement pstmt = con.prepareStatement("update Ban set tinhtrang=0 where maban=?");
                    pstmt.setInt(1, idTable);
                    pstmt.executeUpdate();
                    displayTables();
                    displayTableDrinks();
            } catch (SQLException ex) {
                    Logger.getLogger(frmQuanLyThucDon.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
            
            dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnHomeActionPerformed

    private void txtTotalPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPriceActionPerformed

    private void cboNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNhanVienActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int MaHD = HoaDonDAO.getInstance().GetUncheckInvoiceByTableId(idTable);
            LoaiHang drinks = (LoaiHang) cboDrinks.getSelectedItem();
            NhanVien nv = (NhanVien) cboNhanVien.getSelectedItem();

            if (MaHD != -1) {
                    CTHoaDonDAO.getInstance().Update(MaHD,drinks.getMaLH(),Integer.parseInt(spnAmount.getValue().toString()));
            }
            Connection con = Helper.DatabaseHelper.getDBConnect();
            PreparedStatement pstmt;
            try {
                    pstmt = con.prepareStatement("update Ban set tinhtrang= 1 where MaBan=?");
                    pstmt.setInt(1, idTable);
                    pstmt.executeUpdate();
                    displayTables();
                    displayTableDrinks();
                    btnPay.setEnabled(true);
                    cboDrinks.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(rootPane, "Sửa hóa đơn thành công!!.");
            } catch (SQLException ex) {
                    Logger.getLogger(frmQuanLyThucDon.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }//GEN-LAST:event_btnSuaActionPerformed

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
    private javax.swing.JButton btnSua;
    private javax.swing.JComboBox cboDrinks;
    private javax.swing.JComboBox<Object> cboNhanVien;
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
                        Object[] dt = {tables.getMaBan(), tables.getSoBan(), tables.getTinhTrang()?"Đã đặt":"Trống"};
                        tableModelTables.addRow(dt);
                }
        }

        private void displayTableDrinks() {
                tableModelDrinks.setRowCount(0);
                int totalPrice =0;
                List<Menu> listMenu = MenuDAO.getInstance().GetListMenuByTableId(idTable);
                for (int i = 0; i < listMenu.size(); i++) {
                        Menu menu = listMenu.get(i);
                        Object[] dt = {i + 1, menu.getDrinkName(), menu.getPrice(), menu.getCount(), menu.getTotalPrice()};
                        totalPrice += menu.getTotalPrice();
                        tableModelDrinks.addRow(dt);
                }               
                txtTotalPrice.setText(totalPrice + "");
       }
        
        private void loadDrinks(){
            LoaiHangDAO loaiHang = new LoaiHangDAO();
            List<LoaiHang> list = loaiHang.getAllclasses();
            cboDrinks.removeAllItems();
            cboDrinks.addItem("Chọn đồ uống");
            list.forEach(o -> {
                cboDrinks.addItem(o);
            });
//            try{
//                Connection con = Helper.DatabaseHelper.getDBConnect();
//                String sql = "Select * FROM loaihang";
//                PreparedStatement pstmt = con.prepareStatement(sql);
//                ResultSet rs = pstmt.executeQuery();
//                cboDrinks.removeAllItems();
//                cboDrinks.addItem("Chọn đồ uống");
//                while (rs.next())
//                    {
//                        cboDrinks.addItem(rs.getString("tenLH"));
//                    }
//            
//        }catch (Exception e)
//            {
//                JOptionPane.showMessageDialog(this, e.getMessage());
//                e.printStackTrace();
//            }
        }
        
        private void loadNhanVien(){
            NhanVienDAO nhanVien = new NhanVienDAO();
            List<NhanVien> list = nhanVien.getAllclasses();
            cboNhanVien.removeAllItems();
            cboNhanVien.addItem("Chọn nhân viên");
            list.forEach(o -> {
                cboNhanVien.addItem(o);
            });
//            try{
//                Connection con = Helper.DatabaseHelper.getDBConnect();
//                String sql = "Select * FROM NhanVien";
//                PreparedStatement pstmt = con.prepareStatement(sql);
//                ResultSet rs = pstmt.executeQuery();
//                cboNhanVien.removeAllItems();
//                cboNhanVien.addItem("Chọn nhân viên");
//                while (rs.next())
//                    {
//                        cboNhanVien.addItem(rs.getString("tenNV"));
//                    }
//            
//        }catch (Exception e)
//            {
//                JOptionPane.showMessageDialog(this, e.getMessage());
//                e.printStackTrace();
//            }
        }
        
        
//                private void loadDrinks() {
//                List<LoaiHang> listDrink = LoaiHangDAO.getInstance().listLoaiHang();
//                for (LoaiHang drinks : listDrink) {
//                        comboBoxModel.addElement(drinks);
//                }
//        }
//                
//                private void loadNhanVien() {
//                List<NhanVien> listNhanVien = NhanVienDAO.getInstance().listNhanVien();
//                for (NhanVien nhanvien : listNhanVien) {
//                        comboBoxModel1.addElement(nhanvien);
//                }
//        }
        
}
