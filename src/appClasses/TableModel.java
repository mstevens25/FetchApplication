/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appClasses;
import internalFrames.*;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mattm
 */
public class TableModel extends DefaultTableModel{

    public static void gatherData(JTable table) {
    
        String sql = "SELECT * from customer";
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fetchdb", "root", "mysqlpw");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            TableModel.resultSetToTableModel(rs, table);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void resultSetToTableModel(ResultSet rs, JTable table) throws SQLException{
            //Create new table model
            DefaultTableModel tableModel = new DefaultTableModel();

            //Retrieve meta data from ResultSet
            ResultSetMetaData metaData = rs.getMetaData();

            //Get number of columns from meta data
            int columnCount = metaData.getColumnCount();

            //Get all column names from meta data and add columns to table model
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
                tableModel.addColumn(metaData.getColumnLabel(columnIndex));
            }

            //Create array of Objects with size of column count from meta data
            Object[] row = new Object[columnCount];

            //Scroll through result set
            while (rs.next()){
                //Get object from column with specific index of result set to array of objects
                for (int i = 0; i < columnCount; i++){
                    row[i] = rs.getObject(i+1);
                }
                //Now add row to table model with that array of objects as an argument
                tableModel.addRow(row);
            }

            //Now add that table model to your table and you are done :D
            table.setModel(tableModel);
        }
    
}

