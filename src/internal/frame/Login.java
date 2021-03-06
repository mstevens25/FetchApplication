/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal.frame;
import application.model.EmployeeModel;
import data.validation.*;
import desktop.*;
import fetchfinance1.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Vector;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Matt
 */
public class Login extends javax.swing.JInternalFrame {
    
    EmailFilter loginVal = new EmailFilter();
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        pwtPassword = new javax.swing.JPasswordField();
        btnSubmit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnRecover = new javax.swing.JButton();

        setTitle("LOGIN");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/internal/frame/dog_bowl.jpg"))); // NOI18N
        setVisible(true);

        lblTitle.setFont(new java.awt.Font("Book Antiqua", 0, 24)); // NOI18N
        lblTitle.setText("User Login:");

        lblUsername.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        lblUsername.setText("Username:");

        txtUsername.setFocusCycleRoot(true);
        txtUsername.setNextFocusableComponent(pwtPassword);
        txtUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsernameMouseClicked(evt);
            }
        });

        lblPassword.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        lblPassword.setText("Password:");

        pwtPassword.setNextFocusableComponent(btnSubmit);

        btnSubmit.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.setNextFocusableComponent(btnReset);
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.setMaximumSize(new java.awt.Dimension(77, 25));
        btnReset.setMinimumSize(new java.awt.Dimension(77, 25));
        btnReset.setNextFocusableComponent(btnRecover);

        btnRecover.setText("Recover Login");
        btnRecover.setNextFocusableComponent(txtUsername);
        btnRecover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRecover)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblPassword)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(pwtPassword))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblUsername)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSubmit)
                .addGap(18, 18, 18)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(pwtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRecover))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
   
        boolean chkEmailFormat, isFetchEmail;
        String //email = txtUsername.getText(),
               empPassword = pwtPassword.getText();
        chkEmailFormat = loginVal.validateFormat(txtUsername.getText());
        
         
        
        if(chkEmailFormat) { 
            
            isFetchEmail = loginVal.valCompanyEmail(txtUsername.getText());
            
            if(isFetchEmail){
                
                EmployeeModel emp = EmployeeModel.chkEmpLogin(txtUsername.getText());
                
                if (!(emp.getEmail().equalsIgnoreCase(txtUsername.getText()))){
                    JOptionPane.showMessageDialog(null, "     Invaild Username", "Username Validation", JOptionPane.OK_OPTION);
                    txtUsername.setText("");
                    pwtPassword.setText("");
                } else if(!(emp.getPass().equalsIgnoreCase(empPassword))) {
                    JOptionPane.showMessageDialog(null, "     Incorrect Password", "Password Validation", JOptionPane.OK_OPTION);
                    pwtPassword.setText("");
                } else {
                        switch(emp.getDepartmentId()) {
                        case 1: CSInterface csFrame = new CSInterface();
                                FetchApplication.addInternalFrame(this.getDesktopPane(), csFrame);
                                this.dispose();
                                break;
                        case 2: financeJFrame fnFrame = new financeJFrame();
                                FetchApplication.addInternalFrame(this.getDesktopPane(), fnFrame);
                                this.dispose();
                                break;
                        default: JOptionPane.showMessageDialog(null, "Unable to determine assigned department\n"
                                + "Please contact system adminstrator.", "Email Validation", JOptionPane.OK_OPTION);
                                txtUsername.setText("");
                                pwtPassword.setText("");
                                break;
                        }
                }
            } else {
                JOptionPane.showMessageDialog(null, "                   "
                        + "Incorrect Domain\nPlease use a valid \"Fetch Mobile "
                        + "Grooming\" email.", "Email Validation", JOptionPane.OK_OPTION);
                txtUsername.setText("");
                pwtPassword.setText("");
            }
        } else {
            if(txtUsername.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a username.", "Validation", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Email!", "Email Validation", JOptionPane.OK_OPTION);
                txtUsername.setText("");
                pwtPassword.setText("");
            }
        } 
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMouseClicked
        txtUsername.setText("");
    }//GEN-LAST:event_txtUsernameMouseClicked

    private void btnRecoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecoverActionPerformed
        JOptionPane.showMessageDialog(null, "Please contact your administrator.");
    }//GEN-LAST:event_btnRecoverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRecover;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField pwtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
