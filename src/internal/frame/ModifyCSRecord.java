/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal.frame;

import application.model.CustomerModel;
import application.model.EmployeeModel;
import application.model.GroomerModel;
import desktop.FetchApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author mattm
 */
public class ModifyCSRecord extends javax.swing.JInternalFrame {
    private static char type = 'n';
    
    public static char getType(){
        return ModifyCSRecord.type;
    }
    
    public static void setType(char focusType){
        ModifyCSRecord.type = focusType;
    }
    /**
     * Creates new form ModifyCSRecord
     */
    public ModifyCSRecord() {
        initComponents();
    }
    
    public ModifyCSRecord(CustomerModel cust){
        initComponents();
        
        txtFirstName.setText(cust.getFirstName());
        txtMInitial.setText(cust.getMiddleInitial());
        txtLastName.setText(cust.getLastName());
        txtAddress1.setText(cust.getAddressLine1());
        txtAddress2.setText(cust.getAddressLine2());
        txtCity.setText(cust.getCity());
        cmbState.setSelectedItem(cust.getState());
        txtZip.setText(cust.getZip());
        txtEmail.setText(cust.getEmail());
        txtPassword.setText(cust.getPass());
        txtPhone.setText(cust.getPhone());
        
        
        lblFocusIDValue.setText(Integer.toString(cust.getCustomerId()));
        lblFocusID.setText("Customer ID:");
        
        ModifyCSRecord.setType('c');
    }
    
    public ModifyCSRecord(GroomerModel grm){
        initComponents();
        
        txtFirstName.setText(grm.getFirstName());
        txtMInitial.setText(grm.getMiddleInitial());
        txtLastName.setText(grm.getLastName());
        txtAddress1.setText(grm.getAddressLine1());
        txtAddress2.setText(grm.getAddressLine2());
        txtCity.setText(grm.getCity());
        cmbState.setSelectedItem(grm.getState());
        txtZip.setText(grm.getZip());
        txtEmail.setText(grm.getEmail());
        txtPassword.setText(grm.getPass());
        txtPhone.setText(grm.getPhone());
        
        
        lblFocusIDValue.setText(Integer.toString(grm.getGroomerId()));
        lblFocusID.setText("Groomer ID:");
        
        ModifyCSRecord.setType('g');
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblMInital = new javax.swing.JLabel();
        txtMInitial = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        lblAddress1 = new javax.swing.JLabel();
        txtAddress1 = new javax.swing.JTextField();
        lblAddress2 = new javax.swing.JLabel();
        txtAddress2 = new javax.swing.JTextField();
        lblCity = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        lblState = new javax.swing.JLabel();
        cmbState = new javax.swing.JComboBox<>();
        lblZip = new javax.swing.JLabel();
        txtZip = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lblFocusID = new javax.swing.JLabel();
        lblFocusIDValue = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Modify Record");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modify Record", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 0, 18))); // NOI18N
        jPanel1.setFocusTraversalPolicyProvider(true);

        lblFirstName.setText("First Name:");

        txtFirstName.setToolTipText("");
        txtFirstName.setFocusCycleRoot(true);

        lblMInital.setText("Middle Initial:");

        lblLastName.setText("Last Name:");

        lblPhone.setText("Phone:");

        lblEmail.setText("Email:");

        lblPassword.setText("Password:");

        lblAddress1.setText("Address 1:");

        lblAddress2.setText("Address 2:");

        lblCity.setText("City:");

        lblState.setText("State:");

        cmbState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" }));

        lblZip.setText("ZIP:");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(255, 102, 102));
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        lblFocusID.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        lblFocusID.setText("ID Number:");

        lblFocusIDValue.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        lblFocusIDValue.setText("Invalid");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPassword)
                    .addComponent(lblEmail)
                    .addComponent(lblPhone)
                    .addComponent(lblMInital)
                    .addComponent(lblFirstName)
                    .addComponent(lblLastName))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLastName)
                            .addComponent(txtEmail)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMInitial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 81, Short.MAX_VALUE))
                            .addComponent(txtPassword)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtFirstName)))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAddress1)
                            .addComponent(lblAddress2)
                            .addComponent(lblCity)
                            .addComponent(lblState)
                            .addComponent(lblZip))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtZip, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbState, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFocusID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblFocusIDValue, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSubmit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFocusID)
                    .addComponent(lblFocusIDValue))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress1)
                    .addComponent(txtAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMInitial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblAddress2)
                        .addComponent(txtAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMInital))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCity)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhone)
                    .addComponent(lblState)
                    .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPassword)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblZip)
                            .addComponent(txtZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReset, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSubmit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClose)
                        .addGap(0, 11, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        ModifyCSRecord.modifyRecord(this);
        this.dispose();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtFirstName.setText("");
        txtMInitial.setText("");
        txtLastName.setText("");
        txtAddress1.setText("");
        txtAddress2.setText("");
        txtCity.setText("");
        cmbState.setSelectedIndex(0);
        txtZip.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtPhone.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private static void modifyRecord(ModifyCSRecord modFrame){
        
    Connection conn = null;
    String sql = null;
    String selectedState =  (String) modFrame.cmbState.getSelectedItem();
    
    try {    
        conn = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb", "malderson@fetch-mobile-grooming", "Puppy123"); 
        if(type == 'c'){
            sql = "UPDATE customer"
                +    " SET email = ?, pass = ?, phone = ?, firstName = ?, middleInitial = ?, lastName = ?, addressLine1 = ?, addressLine2 = ?, city = ?, state = ?, zip = ?"
                +    " WHERE customerId = ?;";
        } else {
            sql = "UPDATE groomer"
                +    " SET email = ?, pass = ?, phone = ?, firstName = ?, middleInitial = ?, lastName = ?, addressLine1 = ?, addressLine2 = ?, city = ?, state = ?, zip = ?"
                +    " WHERE groomerId = ?;";
        }
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        
            stmt.setString(1, modFrame.txtEmail.getText());
            stmt.setString(2, modFrame.txtPassword.getText());
            stmt.setString(3, modFrame.txtPhone.getText());
            stmt.setString(4, modFrame.txtFirstName.getText());
            stmt.setString(5, modFrame.txtMInitial.getText());
            stmt.setString(6, modFrame.txtLastName.getText());
            stmt.setString(7, modFrame.txtAddress1.getText());
            stmt.setString(8, modFrame.txtAddress2.getText());
            stmt.setString(9, modFrame.txtCity.getText());
            stmt.setString(10, selectedState);
            stmt.setString(11, modFrame.txtZip.getText());
            
            stmt.setString(12, modFrame.lblFocusIDValue.getText());
            
            int i = stmt.executeUpdate();
            
            if(i>0) {
                JOptionPane.showMessageDialog(null, "Record modified successfully.", "Result", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "Unable to modify Record.", "Result", JOptionPane.OK_OPTION);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally{
        
            try{
                if(conn != null)
                conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cmbState;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAddress1;
    private javax.swing.JLabel lblAddress2;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblFocusID;
    private javax.swing.JLabel lblFocusIDValue;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblMInital;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblZip;
    private javax.swing.JTextField txtAddress1;
    private javax.swing.JTextField txtAddress2;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMInitial;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtZip;
    // End of variables declaration//GEN-END:variables
}
