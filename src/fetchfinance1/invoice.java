/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fetchfinance1;
import java.sql.*;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
import java.util.*;


/**
 *
 * @author Kat
 */
public class invoice {
    
    public static void acPayReport(){
    
    Connection conn = null;
   
    try{
        //create mysql db connection 
     conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fetchdb", "root", "mysqlpw");  
     
     String query = "SELECT * FROM invoice " + "WHERE ";
     
     
     
     Statement stmt = conn.createStatement();
     
     ResultSet acPayData = stmt.executeQuery(query);
     
     Document accountPayable = new Document();
     PdfWriter.getInstance(accountPayable, new FileOutputStream("accountPayableReport.pdf"));
     
     accountPayable.open();
     
     PdfPTable accountPayTable = new PdfPTable(4);
     
     PdfPCell payTableCell;
     
     
     while (acPayData.next()){
         
         String invoiceId = acPayData.getString("invoiceId");
         payTableCell = new PdfPCell(new Phrase(invoiceId));
         
         accountPayTable.addCell(payTableCell);
         String date1 = (acPayData.getString("DATE"));
         
       
     }
     
     
    // ResultSet acData = conn.prepareStatement("SELECT INVOICE");
    }catch(Exception e){
        
    }
}  
    
}
