/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal.frame;
import application.model.CustomerModel;
import com.sun.glass.events.KeyEvent;
import data.validation.*;
import desktop.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author mattm
 */
public class AddCustomerFrame extends javax.swing.JInternalFrame {
    
    DocumentFilter nameFilter = new NameFilter();
    DocumentFilter addrFilter = new AddressFilter();
    DocumentFilter zipFilter = new ZipCodeFilter();
    EmailFilter valEmail = new EmailFilter();
    DocumentFilter phFilter = new PhoneNumberFilter();
    DocumentFilter mInitFilter = new MiddleInitialFilter();
    /**
     * Creates new form AddCustomerFrame
     */
    public AddCustomerFrame() {
        initComponents();
        
        ((AbstractDocument)txtFirstName.getDocument()).setDocumentFilter(nameFilter);
        ((AbstractDocument)txtLastName.getDocument()).setDocumentFilter(nameFilter);
        ((AbstractDocument)txtCity.getDocument()).setDocumentFilter(nameFilter);
        ((AbstractDocument)txtAddress1.getDocument()).setDocumentFilter(addrFilter);
        ((AbstractDocument)txtAddress2.getDocument()).setDocumentFilter(addrFilter);
        ((AbstractDocument)txtZip.getDocument()).setDocumentFilter(zipFilter);
        ((AbstractDocument)txtPhone.getDocument()).setDocumentFilter(phFilter);
        ((AbstractDocument)txtMInitial.getDocument()).setDocumentFilter(mInitFilter);
        
        Toolkit tk = Toolkit.getDefaultToolkit();
            int xsize = (int) tk.getScreenSize().getWidth();
            int ysize = (int) tk.getScreenSize().getHeight();
            
        Dimension frameSize = this.getSize();
            
        this.setLocation((xsize - frameSize.width)/2, (ysize - frameSize.height)/2);
        this.setVisible(true);
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
        lblMInital = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblPassword1 = new javax.swing.JLabel();
        lblAddress1 = new javax.swing.JLabel();
        txtAddress1 = new javax.swing.JTextField();
        lblAddress2 = new javax.swing.JLabel();
        txtAddress2 = new javax.swing.JTextField();
        lblCity = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        lblState = new javax.swing.JLabel();
        cmbState = new javax.swing.JComboBox<>();
        lblZip = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        lblPassword2 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtZip = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtMInitial = new javax.swing.JTextField();

        setTitle("Add New Customer");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/internal/frame/dog_bowl.jpg"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 0, 18))); // NOI18N
        jPanel1.setFocusTraversalPolicyProvider(true);

        lblFirstName.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        lblFirstName.setText("First Name:");

        lblMInital.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        lblMInital.setText("Middle Initial:");

        lblLastName.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        lblLastName.setText("Last Name:");

        txtLastName.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        txtLastName.setNextFocusableComponent(txtPhone);

        lblPhone.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        lblPhone.setText("Phone:");

        lblEmail.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        lblEmail.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        txtEmail.setNextFocusableComponent(txtAddress1);
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        lblPassword1.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        lblPassword1.setText("*Upon submission of this form the new");

        lblAddress1.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        lblAddress1.setText("Address 1:");

        txtAddress1.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        txtAddress1.setNextFocusableComponent(txtAddress2);

        lblAddress2.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        lblAddress2.setText("Address 2:");

        txtAddress2.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        txtAddress2.setNextFocusableComponent(txtCity);

        lblCity.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        lblCity.setText("City:");

        txtCity.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        txtCity.setNextFocusableComponent(cmbState);

        lblState.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        lblState.setText("State:");

        cmbState.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        cmbState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" }));
        cmbState.setNextFocusableComponent(txtZip);

        lblZip.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        lblZip.setText("ZIP:");

        btnSubmit.setBackground(new java.awt.Color(51, 51, 255));
        btnSubmit.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Submit");
        btnSubmit.setNextFocusableComponent(btnReset);
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.setNextFocusableComponent(btnClose);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(255, 102, 102));
        btnClose.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.setNextFocusableComponent(txtFirstName);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        lblPassword2.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        lblPassword2.setText("customer will recieve an email to set their password.");

        txtFirstName.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        txtFirstName.setFocusCycleRoot(true);
        txtFirstName.setNextFocusableComponent(txtMInitial);

        txtZip.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        txtZip.setNextFocusableComponent(btnSubmit);

        txtPhone.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        txtPhone.setNextFocusableComponent(txtEmail);

        txtMInitial.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        txtMInitial.setNextFocusableComponent(txtLastName);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEmail)
                            .addComponent(lblPhone)
                            .addComponent(lblMInital)
                            .addComponent(lblFirstName)
                            .addComponent(lblLastName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtLastName))
                                        .addGap(21, 21, 21))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMInitial, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblAddress2)
                                    .addComponent(lblCity)
                                    .addComponent(lblState)
                                    .addComponent(lblZip)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtFirstName)
                                .addGap(21, 21, 21)
                                .addComponent(lblAddress1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPassword2)
                            .addComponent(lblPassword1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtAddress2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addComponent(txtCity)
                        .addComponent(txtAddress1)
                        .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtZip, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName)
                    .addComponent(lblAddress1)
                    .addComponent(txtAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblAddress2)
                        .addComponent(txtAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMInital)
                        .addComponent(txtMInitial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCity)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(lblState)
                    .addComponent(cmbState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblZip)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail)
                    .addComponent(txtZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lblPassword1)
                        .addGap(5, 5, 5)
                        .addComponent(lblPassword2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSubmit)
                            .addComponent(btnReset))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClose)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        String selectedState =  (String) cmbState.getSelectedItem();
        String phoneNum = txtPhone.getText();
        phoneNum = phoneNum.replaceAll("-", "");
        
        if (selectedState == "--") selectedState = "";

        if (selectedState == "") {
            JOptionPane.showMessageDialog(null, "Unable to add new customer", "No State Selected", JOptionPane.OK_OPTION);
        } else if (txtFirstName.getText() == "" || txtLastName.getText() == "" || txtCity.getText() == "" || 
                txtEmail.getText() == "" || txtPhone.getText().length() < 12 ||  txtZip.getText().length() < 5){
            JOptionPane.showMessageDialog(null, "Unable to add new customer", "Missing Field Values", JOptionPane.OK_OPTION);
        } else {

            CustomerModel tempCust = new CustomerModel(txtEmail.getText(), "newCustomer!", phoneNum,
                txtFirstName.getText(), txtMInitial.getText(), txtLastName.getText(), txtAddress1.getText(),
                txtAddress2.getText(), txtCity.getText(), selectedState, txtZip.getText());

            CustomerModel.addCustomer(tempCust);
            
            try {
                txtFirstName.getDocument().remove(0, txtFirstName.getText().length());
                txtLastName.getDocument().remove(0, txtLastName.getText().length());
                txtCity.getDocument().remove(0, txtCity.getText().length());
                txtAddress1.getDocument().remove(0, txtAddress1.getText().length());
                txtAddress2.getDocument().remove(0, txtAddress2.getText().length());
                txtZip.getDocument().remove(0, txtZip.getText().length());
                txtPhone.getDocument().remove(0, txtPhone.getText().length());
                txtMInitial.getDocument().remove(0, txtMInitial.getText().length());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            cmbState.setSelectedIndex(0);
            txtEmail.setText("");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        try {
            txtFirstName.getDocument().remove(0, txtFirstName.getText().length());
            txtLastName.getDocument().remove(0, txtLastName.getText().length());
            txtCity.getDocument().remove(0, txtCity.getText().length());
            txtAddress1.getDocument().remove(0, txtAddress1.getText().length());
            txtAddress2.getDocument().remove(0, txtAddress2.getText().length());
            txtZip.getDocument().remove(0, txtZip.getText().length());
            txtPhone.getDocument().remove(0, txtPhone.getText().length());
            txtMInitial.getDocument().remove(0, txtMInitial.getText().length());
        } catch (Exception e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        }
        cmbState.setSelectedIndex(0);
        txtEmail.setText("");

    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if (!valEmail.validateFormat(txtEmail.getText()))
        {
            JOptionPane.showMessageDialog(null, "Please enter a valid email address.", "Invalid Email", JOptionPane.OK_OPTION);
            txtEmail.setText("");
        }
    }//GEN-LAST:event_txtEmailFocusLost


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
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblMInital;
    private javax.swing.JLabel lblPassword1;
    private javax.swing.JLabel lblPassword2;
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
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtZip;
    // End of variables declaration//GEN-END:variables
}
