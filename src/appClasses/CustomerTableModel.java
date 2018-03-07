/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appClasses;

import java.sql.*;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

/**
 *
 * @author mattm
 */
public class CustomerTableModel {
    
    ResultSetMetaData metadata;
    int numcols, numrows;
    
    public CustomerTableModel(CachedRowSet rowSetArg)
        throws SQLException {

        this.customerRowSet = rowSetArg;
        this.metadata = this.customerRowSet.getMetaData();
        numcols = metadata.getColumnCount();

        // Retrieve the number of rows.
        this.customerRowSet.beforeFirst();
        this.numrows = 0;
        while (this.customerRowSet.next()) {
            this.numrows++;
        }
        this.customerRowSet.beforeFirst();
    }
    
    public int getColumnCount() { return numcols; }

    public int getRowCount() { return numrows; }
    
    public Class getColumnClass(int column) { return String.class; }
    
    public String getColumnName(int column) {
        try {
            return this.metadata.getColumnLabel(column + 1);
        } catch (SQLException e) {
            return e.toString(); }
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {

        try {
            this.customerRowSet.absolute(rowIndex + 1);
            Object o = this.customerRowSet.getObject(columnIndex + 1);
            if (o == null) {
                return null;
            } else {
                return o.toString(); }
        } catch (SQLException e) {
            return e.toString();
        }
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    
}
