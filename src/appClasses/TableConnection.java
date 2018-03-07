/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appClasses;
import internalFrames.*;
import desktop.*;
import inputValidation.*;

import java.sql.*;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author mattm
 */
public class TableConnection {

    
public static void pullData(){  
    
    Connection conn = null;
    Vector data = new Vector();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
            ResultSetMetaData metaData = rs.getMetaData();
            int columns = metaData.getColumnCount();
            while (rs.next()) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++) {
                    row.addElement(rs.getObject(i));
                }
            data.addElement(row); }
        } catch (SQLException e) {
            e.printStackTrace(); }
        
        Vector columnNames = new Vector();
        
        columnNames.addElement("Customer ID");
        columnNames.addElement("Email");
        columnNames.addElement("Password");
        columnNames.addElement("Phone");
        columnNames.addElement("First Name");
        columnNames.addElement("Middle Initial");
        columnNames.addElement("Last Name");
        columnNames.addElement("Address 1");
        columnNames.addElement("Address 2");
        columnNames.addElement("City");
        columnNames.addElement("State");
        columnNames.addElement("ZIP");
        
        
        
        
}
}
