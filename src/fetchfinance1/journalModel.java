/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fetchfinance1;

import java.sql.Date;

/**
 *
 * @author Kat
 */
public class journalModel {
    
    int entryId;
    String entryType, entryStmt;
    java.sql.Date entryDate;
        
    public journalModel(int id, Date date, String type, String stmt){
        
        this.entryId = id;
        this.entryDate = date;
        this.entryType = type;
        this.entryStmt = stmt;
        
    }
    
    public int getEntryId(){
        
        return this.entryId;
    }
    
    public Date getEntryDate(){
        
        return this.entryDate;
       
    }
    
    public String getEntryType(){
        
        return this.entryType;
    }
    
    public String getEntryStmt(){
        
        return this.entryStmt;
    }
    
    
}
