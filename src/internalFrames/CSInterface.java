/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalFrames;
import appClasses.*;

import java.awt.*;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Vector;
import javax.sql.RowSetEvent;
import javax.sql.rowset.CachedRowSet;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
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
        
        CSTableModel searchTbl = new CSTableModel();
        searchTbl.getData(tblSearchRs, "null");
        tblSearchRs.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngObjType = new javax.swing.ButtonGroup();
        scpnCustTable = new javax.swing.JScrollPane();
        tblSearchRs = new javax.swing.JTable();
        lblCustTblTitle = new javax.swing.JLabel();
        pnlCurrentFocus = new javax.swing.JPanel();
        btnAddRecord = new javax.swing.JButton();
        btnTblRefresh = new javax.swing.JButton();
        rbCustomer = new javax.swing.JRadioButton();
        rbGroomer = new javax.swing.JRadioButton();
        rbPet = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        pnlCalendar = new javax.swing.JPanel();
        jCalendar1 = new com.toedter.calendar.JCalendar();

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

        tblSearchRs.setModel(new javax.swing.table.DefaultTableModel(
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
        scpnCustTable.setViewportView(tblSearchRs);

        lblCustTblTitle.setFont(new java.awt.Font("Book Antiqua", 0, 24)); // NOI18N
        lblCustTblTitle.setText("SEARCH RESULTS:");

        pnlCurrentFocus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Current Focus", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 0, 24))); // NOI18N

        btnAddRecord.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        btnAddRecord.setText("Add Record");
        btnAddRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRecordActionPerformed(evt);
            }
        });

        btnTblRefresh.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        btnTblRefresh.setText("Refresh Table");
        btnTblRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTblRefreshActionPerformed(evt);
            }
        });

        btngObjType.add(rbCustomer);
        rbCustomer.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        rbCustomer.setText("Customer");

        btngObjType.add(rbGroomer);
        rbGroomer.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        rbGroomer.setText("Groomer");

        btngObjType.add(rbPet);
        rbPet.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        rbPet.setText("Pet");

        jButton1.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jButton1.setText("Search");

        javax.swing.GroupLayout pnlCurrentFocusLayout = new javax.swing.GroupLayout(pnlCurrentFocus);
        pnlCurrentFocus.setLayout(pnlCurrentFocusLayout);
        pnlCurrentFocusLayout.setHorizontalGroup(
            pnlCurrentFocusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCurrentFocusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCurrentFocusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCurrentFocusLayout.createSequentialGroup()
                        .addComponent(rbPet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddRecord))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCurrentFocusLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlCurrentFocusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCurrentFocusLayout.createSequentialGroup()
                                .addComponent(rbGroomer)
                                .addGap(93, 93, 93)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCurrentFocusLayout.createSequentialGroup()
                                .addComponent(rbCustomer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTblRefresh)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCurrentFocusLayout.setVerticalGroup(
            pnlCurrentFocusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCurrentFocusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCurrentFocusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTblRefresh)
                    .addComponent(rbCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCurrentFocusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rbGroomer)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCurrentFocusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbPet)
                    .addComponent(btnAddRecord))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pnlCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calendar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 0, 18))); // NOI18N

        jCalendar1.setWeekOfYearVisible(false);

        javax.swing.GroupLayout pnlCalendarLayout = new javax.swing.GroupLayout(pnlCalendar);
        pnlCalendar.setLayout(pnlCalendarLayout);
        pnlCalendarLayout.setHorizontalGroup(
            pnlCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCalendarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCalendarLayout.setVerticalGroup(
            pnlCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCalendarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpnCustTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1945, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCustTblTitle)
                            .addComponent(pnlCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlCurrentFocus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCurrentFocus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCustTblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpnCustTable, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTblRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTblRefreshActionPerformed
      
        String objType = this.getSelectedButtonText(btngObjType);
        
        if (objType == "Customer" || objType == "Groomer" || objType == "Pet") {
        
        CSTableModel.getData(tblSearchRs, objType);
        tblSearchRs.setVisible(true); }
        else {
            JOptionPane.showMessageDialog(rootPane, "Please select an object.", "Invalid", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTblRefreshActionPerformed

    private void winClose(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_winClose
        Login initLogin = new Login();
        this.getDesktopPane().add(initLogin);        
    }//GEN-LAST:event_winClose

    private void btnAddRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRecordActionPerformed
        //addCustomer addCust = new addCustomer();
        //this.getParent().add(addCust);
        //addCust.setVisible(true);
        //addCust.moveToFront();
    }//GEN-LAST:event_btnAddRecordActionPerformed

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
            
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRecord;
    private javax.swing.JButton btnTblRefresh;
    private javax.swing.ButtonGroup btngObjType;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel lblCustTblTitle;
    private javax.swing.JPanel pnlCalendar;
    private javax.swing.JPanel pnlCurrentFocus;
    private javax.swing.JRadioButton rbCustomer;
    private javax.swing.JRadioButton rbGroomer;
    private javax.swing.JRadioButton rbPet;
    private javax.swing.JScrollPane scpnCustTable;
    private javax.swing.JTable tblSearchRs;
    // End of variables declaration//GEN-END:variables
}
