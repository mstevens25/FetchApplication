/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fetchfinance1;

/**
 *
 * @author Kat
 */
public class invoiceModel {
    
    int invoiceID;
    double invoiceTotal;
    java.sql.Date invoiceDate;
    String invoiceType, invoiceSource, invoiceTags ;
    
    public invoiceModel(int id,java.sql.Date date,String type, double total, String source, String tags ){
    
        this.invoiceID = id;
        this.invoiceDate = date;
        this.invoiceType = type;
        this.invoiceTotal = total;
        this.invoiceSource = source;
        this.invoiceTags = tags;
    }
    
    public int getInvoiceId(){
        
        return this.invoiceID;
    }
    
    public java.sql.Date getInvoiceDate(){
        
    return this.invoiceDate;
    }
    
    public String getInvoiceType(){
        return this.invoiceType;
    }
    
    public double getInvoiceTotal(){
        return this.invoiceTotal;
    }
    
    public String getInvoiceSource(){
        return this.invoiceSource;
    }
    
    public String getInvoiceTags(){
        return this.invoiceTags;
    }
}
