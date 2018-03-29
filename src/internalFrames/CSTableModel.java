/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalFrames;
import appClasses.*;
import desktop.*;
import inputValidation.*;
import internalFrames.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mattm
 */
public class CSTableModel {
    
    
     public static void getData(JTable table, String focus){
        
        String sql = null;
        DefaultTableModel tblModel = null;
        Connection conn = null;
                        
        
        if (focus == "Groomer") {
            sql = "select * from groomer"; }
        else if (focus == "Pet") {
            sql = "select * from pet"; }
        else {
            sql = "select * from customer"; }
         
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb", "malderson@fetch-mobile-grooming", "Puppy123"); 
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
             // It creates and displays the table
            tblModel = CSTableModel.buildTableModel(rs);

            table.setModel(tblModel);
            // Closes the Connection
            //JOptionPane.showMessageDialog(null, new JScrollPane(table));
            
            
           
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
      
    }
    
    
    public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}
}
