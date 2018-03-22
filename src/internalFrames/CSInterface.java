/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalFrames;
import appClasses.*;

import java.awt.*;
import java.sql.SQLException;
import java.util.Vector;
import javax.sql.RowSetEvent;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Matt
 */
public class CSInterface extends javax.swing.JInternalFrame {
    

    /**
     * Creates new form CSInterface
     */
    public CSInterface() {
        initComponents();
        
        Toolkit tk = Toolkit.getDefaultToolkit();
            int xsize = (int) tk.getScreenSize().getWidth();
            int ysize = (int) tk.getScreenSize().getHeight();
            
        this.setSize(xsize, ysize);
    
        this.setVisible(true);
        
        CustomerTableModel custDB = new CustomerTableModel();
        custDB.getData(custTable);
        
        GroomerTableModel grmDB = new GroomerTableModel();
        grmDB.getData(grmTable);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scpnCustTable = new javax.swing.JScrollPane();
        custTable = new javax.swing.JTable();
        lblCustTblTitle = new javax.swing.JLabel();
        scpnPetTable = new javax.swing.JScrollPane();
        petTable = new javax.swing.JTable();
        lblGrmTblTitle = new javax.swing.JLabel();
        scpnGrmTable = new javax.swing.JScrollPane();
        grmTable = new javax.swing.JTable();
        lblPetTblTitle = new javax.swing.JLabel();
        pnlCustOptions = new javax.swing.JPanel();
        btnAddCust = new javax.swing.JButton();
        btnCustTblRefresh = new javax.swing.JButton();
        pnlGrmOptions = new javax.swing.JPanel();
        btnGrmTblRefresh = new javax.swing.JButton();
        btnAddGrm = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnGrmTblRefresh1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("CUSTOMER SERVICE PORTAL");
        setFocusTraversalPolicyProvider(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                winClose(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        custTable.setModel(new javax.swing.table.DefaultTableModel(
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
        scpnCustTable.setViewportView(custTable);

        lblCustTblTitle.setFont(new java.awt.Font("Book Antiqua", 1, 24)); // NOI18N
        lblCustTblTitle.setText("CUSTOMERS");

        petTable.setModel(new javax.swing.table.DefaultTableModel(
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
        scpnPetTable.setViewportView(petTable);

        lblGrmTblTitle.setFont(new java.awt.Font("Book Antiqua", 1, 24)); // NOI18N
        lblGrmTblTitle.setText("GROOMERS");

        grmTable.setModel(new javax.swing.table.DefaultTableModel(
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
        scpnGrmTable.setViewportView(grmTable);

        lblPetTblTitle.setFont(new java.awt.Font("Book Antiqua", 1, 24)); // NOI18N
        lblPetTblTitle.setText("PETS");

        pnlCustOptions.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 0, 18))); // NOI18N

        btnAddCust.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        btnAddCust.setText("Add Customer");
        btnAddCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustActionPerformed(evt);
            }
        });

        btnCustTblRefresh.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        btnCustTblRefresh.setText("Refresh Table");
        btnCustTblRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustTblRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCustOptionsLayout = new javax.swing.GroupLayout(pnlCustOptions);
        pnlCustOptions.setLayout(pnlCustOptionsLayout);
        pnlCustOptionsLayout.setHorizontalGroup(
            pnlCustOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCustOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddCust, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCustTblRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(405, Short.MAX_VALUE))
        );
        pnlCustOptionsLayout.setVerticalGroup(
            pnlCustOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddCust, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(btnCustTblRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlGrmOptions.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Groomer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 0, 18))); // NOI18N

        btnGrmTblRefresh.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        btnGrmTblRefresh.setText("Refresh Table");
        btnGrmTblRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrmTblRefreshActionPerformed(evt);
            }
        });

        btnAddGrm.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        btnAddGrm.setText("Add Groomer");
        btnAddGrm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGrmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGrmOptionsLayout = new javax.swing.GroupLayout(pnlGrmOptions);
        pnlGrmOptions.setLayout(pnlGrmOptionsLayout);
        pnlGrmOptionsLayout.setHorizontalGroup(
            pnlGrmOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGrmOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGrmOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGrmTblRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddGrm, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(381, Short.MAX_VALUE))
        );
        pnlGrmOptionsLayout.setVerticalGroup(
            pnlGrmOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGrmOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddGrm, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(btnGrmTblRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pet", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 0, 18))); // NOI18N

        btnGrmTblRefresh1.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        btnGrmTblRefresh1.setText("Refresh Table");
        btnGrmTblRefresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrmTblRefresh1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGrmTblRefresh1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGrmTblRefresh1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpnCustTable, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scpnPetTable)
                    .addComponent(scpnGrmTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1873, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPetTblTitle)
                            .addComponent(lblGrmTblTitle)
                            .addComponent(lblCustTblTitle)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(pnlCustOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(pnlGrmOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlGrmOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCustOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lblCustTblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpnCustTable, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblGrmTblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpnGrmTable, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPetTblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scpnPetTable, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCustTblRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustTblRefreshActionPerformed
        CustomerTableModel.getData(custTable);        // TODO add your handling code here:
    }//GEN-LAST:event_btnCustTblRefreshActionPerformed

    private void winClose(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_winClose
        Login initLogin = new Login();
        this.getDesktopPane().add(initLogin);        
    }//GEN-LAST:event_winClose

    private void btnAddCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustActionPerformed
        addCustomer addCust = new addCustomer();
        this.getParent().add(addCust);
        addCust.setVisible(true);
        addCust.moveToFront();
    }//GEN-LAST:event_btnAddCustActionPerformed

    private void btnGrmTblRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrmTblRefreshActionPerformed
        GroomerTableModel.getData(grmTable); 
    }//GEN-LAST:event_btnGrmTblRefreshActionPerformed

    private void btnAddGrmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGrmActionPerformed
        addGroomer addGrm = new addGroomer();
        this.getParent().add(addGrm);
        addGrm.setVisible(true);
        addGrm.moveToFront();
    }//GEN-LAST:event_btnAddGrmActionPerformed

    private void btnGrmTblRefresh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrmTblRefresh1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGrmTblRefresh1ActionPerformed

    

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCust;
    private javax.swing.JButton btnAddGrm;
    private javax.swing.JButton btnCustTblRefresh;
    private javax.swing.JButton btnGrmTblRefresh;
    private javax.swing.JButton btnGrmTblRefresh1;
    private javax.swing.JTable custTable;
    private javax.swing.JTable grmTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCustTblTitle;
    private javax.swing.JLabel lblGrmTblTitle;
    private javax.swing.JLabel lblPetTblTitle;
    private javax.swing.JTable petTable;
    private javax.swing.JPanel pnlCustOptions;
    private javax.swing.JPanel pnlGrmOptions;
    private javax.swing.JScrollPane scpnCustTable;
    private javax.swing.JScrollPane scpnGrmTable;
    private javax.swing.JScrollPane scpnPetTable;
    // End of variables declaration//GEN-END:variables
}
