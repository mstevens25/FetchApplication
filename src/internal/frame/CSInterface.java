/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal.frame;
import application.model.CustomerModel;
import application.model.DBTableModel;
import application.model.GroomerModel;
import desktop.FetchApplication;

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
        
        
        /*
        DBTableModel searchTbl = new DBTableModel();
        searchTbl.getData(tblSearchRs, "null");
        tblSearchRs.setVisible(false);
        */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngFocus = new javax.swing.ButtonGroup();
        pnlModify = new javax.swing.JPanel();
        txtFocusID = new javax.swing.JTextField();
        lblFocusID = new javax.swing.JLabel();
        btnModify = new javax.swing.JButton();
        btnAddPet = new javax.swing.JButton();
        pnlCurrentFocus = new javax.swing.JPanel();
        rbCustomer = new javax.swing.JRadioButton();
        rbGroomer = new javax.swing.JRadioButton();
        btnAddRecord = new javax.swing.JButton();
        pnlSearch = new javax.swing.JPanel();
        lblField1 = new javax.swing.JLabel();
        cmbField1 = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        txtField1 = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("CUSTOMER SERVICE PORTAL");
        setFocusTraversalPolicyProvider(true);
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/internal/frame/dog_bowl.jpg"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(624, 307));
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

        pnlModify.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modify", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 0, 18))); // NOI18N

        lblFocusID.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        lblFocusID.setText("ID Number:");

        btnModify.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        btnModify.setText("Modify Record");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        btnAddPet.setText("Add Pet (Customer Only)");
        btnAddPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlModifyLayout = new javax.swing.GroupLayout(pnlModify);
        pnlModify.setLayout(pnlModifyLayout);
        pnlModifyLayout.setHorizontalGroup(
            pnlModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModifyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlModifyLayout.createSequentialGroup()
                        .addComponent(lblFocusID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFocusID, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlModifyLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddPet)
                            .addComponent(btnModify))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlModifyLayout.setVerticalGroup(
            pnlModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModifyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlModifyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFocusID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFocusID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModify)
                .addGap(18, 18, 18)
                .addComponent(btnAddPet)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCurrentFocus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Current Focus", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 0, 18))); // NOI18N

        btngFocus.add(rbCustomer);
        rbCustomer.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        rbCustomer.setSelected(true);
        rbCustomer.setText("Customer");

        btngFocus.add(rbGroomer);
        rbGroomer.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        rbGroomer.setText("Groomer");

        btnAddRecord.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        btnAddRecord.setText("Add Record");
        btnAddRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRecordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCurrentFocusLayout = new javax.swing.GroupLayout(pnlCurrentFocus);
        pnlCurrentFocus.setLayout(pnlCurrentFocusLayout);
        pnlCurrentFocusLayout.setHorizontalGroup(
            pnlCurrentFocusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCurrentFocusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbCustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbGroomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btnAddRecord)
                .addContainerGap())
        );
        pnlCurrentFocusLayout.setVerticalGroup(
            pnlCurrentFocusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCurrentFocusLayout.createSequentialGroup()
                .addGroup(pnlCurrentFocusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCustomer)
                    .addComponent(rbGroomer)
                    .addComponent(btnAddRecord))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pnlSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 0, 18))); // NOI18N

        lblField1.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        lblField1.setText("Field 1:");

        cmbField1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------", "Email", "Last Name", "ID Number" }));

        btnSearch.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSearchLayout.createSequentialGroup()
                        .addComponent(lblField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbField1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSearchLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblField1)
                    .addComponent(cmbField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(btnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCurrentFocus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCurrentFocus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlModify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void winClose(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_winClose
        Login loginFrame = new Login();
        FetchApplication.addInternalFrame(this.getDesktopPane(), loginFrame);
    }//GEN-LAST:event_winClose

    private void btnAddRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRecordActionPerformed
        if(this.getSelectedButtonText(btngFocus).equals("Customer")) {
            AddCustomerFrame addCust = new AddCustomerFrame();
            FetchApplication.addInternalFrame(this.getDesktopPane(), addCust);
            addCust.setVisible(true);
            addCust.moveToFront();
        } else {
            AddGroomerFrame addGrm = new AddGroomerFrame();
            FetchApplication.addInternalFrame(this.getDesktopPane(), addGrm);
            addGrm.setVisible(true);
            addGrm.moveToFront();
        }
    }//GEN-LAST:event_btnAddRecordActionPerformed

    private void btnAddPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPetActionPerformed
        AddPetFrame addPet = new AddPetFrame(txtFocusID.getText());
        FetchApplication.addInternalFrame(this.getDesktopPane(), addPet);
        addPet.setVisible(true);
        addPet.moveToFront();
    }//GEN-LAST:event_btnAddPetActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        cmbField1.setSelectedIndex(0);
        //cmbField2.setSelectedIndex(0);
        txtField1.setText("");
        //txtField2.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        CustomerModel cust = new CustomerModel();
        GroomerModel grm = new GroomerModel();
        
        if(txtFocusID.getText().equals("")){
            JOptionPane.showMessageDialog(null, "     Please enter an ID number, up to six numeric digits.", 
                    "ID Number Validation", JOptionPane.OK_OPTION);
        } else {
            if(this.getSelectedButtonText(btngFocus).equals("Customer")) {
                cust = CustomerModel.setFocus(Integer.parseInt(txtFocusID.getText()));
        
                if(cust.getCustomerId() == -1){
                    JOptionPane.showMessageDialog(null, "     Customer not found.", 
                            "Customer ID Validation", JOptionPane.OK_OPTION);
                } else {
                    ModifyCSRecord modRecFrame = new ModifyCSRecord(cust);
                    FetchApplication.addInternalFrame(this.getDesktopPane(), modRecFrame);
                    modRecFrame.setVisible(true);
                    modRecFrame.moveToFront();
                }
            } else {
                grm = GroomerModel.setFocus(Integer.parseInt(txtFocusID.getText()));
        
                if(grm.getGroomerId() == -1){
                    JOptionPane.showMessageDialog(null, "     Groomer not found.", 
                            "Groomer ID Validation", JOptionPane.OK_OPTION);
                } else {
                    ModifyCSRecord modRecFrame = new ModifyCSRecord(grm);
                    FetchApplication.addInternalFrame(this.getDesktopPane(), modRecFrame);
                    modRecFrame.setVisible(true);
                    modRecFrame.moveToFront();
                }
            }
        }
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String fieldOne = null,
               sType = this.getSelectedButtonText(btngFocus); 
        int sField = cmbField1.getSelectedIndex();
        

        
        if(cmbField1.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "     Please select a field type.", 
                            "Search Field Check", JOptionPane.OK_OPTION);
        } else if (txtField1.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "     Please enter a field value.", 
                            "Search Field Check", JOptionPane.OK_OPTION);
        } else {
            CSSearchFrame sFrame = new CSSearchFrame(sType, sField, this.txtField1.getText());
            FetchApplication.addInternalFrame(this.getDesktopPane(), sFrame);
            sFrame.setVisible(true);
            sFrame.moveToFront();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

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
    private javax.swing.JButton btnAddPet;
    private javax.swing.JButton btnAddRecord;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup btngFocus;
    private javax.swing.JComboBox<String> cmbField1;
    private javax.swing.JLabel lblField1;
    private javax.swing.JLabel lblFocusID;
    private javax.swing.JPanel pnlCurrentFocus;
    private javax.swing.JPanel pnlModify;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JRadioButton rbCustomer;
    private javax.swing.JRadioButton rbGroomer;
    private javax.swing.JTextField txtField1;
    private javax.swing.JTextField txtFocusID;
    // End of variables declaration//GEN-END:variables
}
