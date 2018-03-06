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
/**
 *
 * @author mattm
 */
public class TableConnection {
    
    
public static void pullData(){  
    
    Connection conn = null;
    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fetchdb", "root", "mysqlpw");   
        PreparedStatement stmt = conn.prepareStatement("SELECT * from customers");
        ResultSet rs = stmt.executeQuery();
        
    } catch (SQLException e) {
        e.printStackTrace(); }
}
}