package appClasses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import internalFrames.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author mattm
 */
public class CustomerTableModel {
    
    
    
    public static void getData(JTable table){
        
        DefaultTableModel tblModel = null;
        Connection conn = null;
        String sql = "SELECT * from customer";
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fetchdb", "root", "mysqlpw"); 
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
             // It creates and displays the table
            tblModel = CustomerTableModel.buildTableModel(rs);

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
