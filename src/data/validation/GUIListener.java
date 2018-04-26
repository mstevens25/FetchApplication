/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.validation;

import java.awt.event.*;
import javax.swing.JOptionPane;
/**
 *
 * @author mattm
 */
public class GUIListener implements ActionListener{
    
    public void actionPerformed(ActionEvent e){
        Object command = e.getSource();
        if (command.equals("txtFirstName")) {
            handleText(e);
        } else if (command.equals("bar")) {
            //handleBar(e);
        }
    }

    private void handleText(ActionEvent e) {
    JOptionPane.showMessageDialog(null, "Unable to Add New Customer", "Result", JOptionPane.OK_OPTION);
    }
    //private void handleBar(ActionEvent e) {...}
}

