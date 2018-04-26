/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.model;
import desktop.*;
import data.validation.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mattm
 */
public class DBTableModel {
     
    
    public static void searchData(JTable table, String focus, int sType, String search){
        
        String sql = null,
               focusType = null;
        DefaultTableModel tblModel = null;
        Connection conn = null;
                        
        
        if (focus == "Groomer") {
            sql = "SELECT * from groomer"; 
            focusType = "groomerId"; 
        } else if (focus == "Pet") {
            sql = "SELECT * from pet";
            focusType = "petId"; 
        } else if (focus == "Customer"){
            sql = "SELECT * from customer"; 
            focusType = "customerId"; 
        } else {
            sql = "SElECT * from groomer";
            focusType = "zip";
        }
        
        if(sType == 1){
                sql = sql.concat(" WHERE " + "email='" + search + "';");
            } else if (sType == 2){
                sql = sql.concat(" WHERE " + "lastName='" + search + "';");
            } else if (sType == 3) {
                sql = sql.concat(" WHERE " + focusType + "='" + search + "';");
            } else {
                sql = sql.concat(" WHERE " + "zip='" + search + "';");
            }
        
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb", "malderson@fetch-mobile-grooming", "Puppy123");             
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);

            tblModel = DBTableModel.buildTableModel(rs);
            table.setModel(tblModel);
            
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally{
        
            try{
                if(conn != null)
                conn.close(); }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
      
    }
    
    
    public static void viewAppts(JTable table, int id, char type){
        
        String sql = null;
        DefaultTableModel tblModel = null;
        Connection conn = null;
                        
        
        if (type == 'c') {
            sql = "SELECT * from appointment WHERE customerId=" + id + ";"; 
        } else if (type == 'g') {
            sql = "SELECT * from appointment WHERE groomerId=" + id + ";";
        }

        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb", "malderson@fetch-mobile-grooming", "Puppy123");             
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);

            // It creates and displays the table
            tblModel = DBTableModel.buildTableModel(rs);

            table.setModel(tblModel);
            // Closes the Connection
            //JOptionPane.showMessageDialog(null, new JScrollPane(table));
         
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally{
        
            try{
                if(conn != null)
                conn.close(); }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
      
    }
    
    public static void viewPets(JTable table, int id){
        
        String sql = "SELECT * from pet WHERE customerId=" + id+ ";";
        DefaultTableModel tblModel = null;
        Connection conn = null;
                        
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb", "malderson@fetch-mobile-grooming", "Puppy123");             
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);

            // It creates and displays the table
            tblModel = DBTableModel.buildTableModel(rs);

            table.setModel(tblModel);
            // Closes the Connection
            //JOptionPane.showMessageDialog(null, new JScrollPane(table));
            
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally{
        
            try{
                if(conn != null)
                conn.close(); }
            catch(SQLException se){
                se.printStackTrace();
            }
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
