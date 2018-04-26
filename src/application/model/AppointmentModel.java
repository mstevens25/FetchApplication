/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author mattm
 */
public class AppointmentModel {
    private int apptId,
                custId,
                grmId,
                petId;
    private Date date;
    private String notes,
                   time;
    
    public int getApptId(){ return apptId; }
    public int getCustId(){ return custId; }
    public int getGrmId(){ return grmId; }
    public int getPetId(){ return petId; }
    public Date getDate(){ return date; }
    public String getNotes(){ return notes; }
    public String getTime(){ return time; }
    
    public void setApptId(int id){ this.apptId = id; }
    public void setCustId(int id){ this.custId = id; }
    public void setGrmId(int id){ this.grmId = id; }
    public void setPetId(int id){ this.petId = id; }
    public void setDate(Date date){ this.date = date; }
    public void setNotes(String notes){ this.notes = notes; }
    public void setTime(String time){ this.time = time; }
    
    
    public AppointmentModel(){    
    }
    
    public AppointmentModel(int custId, int grmId, int petId, Date date, String notes, String time) throws ParseException{
           
        this.setCustId(custId);
        this.setGrmId(grmId);
        this.setPetId(petId);
        this.setDate(date);
        this.setNotes(notes);
        this.setTime(time);
    }
    
    public static void addAppointment(AppointmentModel appt) {
        
        Connection conn = null;

        
        String custId = Integer.toString(appt.getCustId()),
                grmId = Integer.toString(appt.getGrmId()),
                petId = Integer.toString(appt.getPetId()),
                notes = appt.getNotes(),
                time = appt.getTime();
        java.sql.Date date = appt.getDate();
        
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb", "malderson@fetch-mobile-grooming", "Puppy123"); 
            PreparedStatement stmt = conn.prepareStatement("insert into appointment"
                +    " (customerId, groomerId, petId, appointmentDate, notes, apptTime)"
                +    " values (?,?,?,?,?, ?)");
            
            stmt.setString(1, custId);
            stmt.setString(2, grmId);
            stmt.setString(3, petId);
            stmt.setDate(4, date);
            stmt.setString(5, notes);
            stmt.setString(6, time);
            
            int i = stmt.executeUpdate();
            
            if(i>0) {
                JOptionPane.showMessageDialog(null, "New Appointment Added Successfully.", "Result", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "Unable to Add New Appointment", "Result", JOptionPane.OK_OPTION);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } finally{
        
            try{
                if(conn != null)
                conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
    
    
    public static AppointmentModel setFocus(int id){
        Connection conn = null;
        String sql = "SELECT * FROM appointment";
        AppointmentModel appt = new AppointmentModel();
        appt.setApptId(-1);
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb", "malderson@fetch-mobile-grooming", "Puppy123");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                if(rs.getInt("appointmentId") == id){
                    appt.setApptId(rs.getInt("appointmentId"));
                    appt.setCustId(rs.getInt("customerId"));
                    appt.setGrmId(rs.getInt("groomerId"));
                    appt.setPetId(rs.getInt("petId"));
                    appt.setDate(rs.getDate("appointmentDate"));
                    appt.setNotes(rs.getString("notes"));
                    appt.setTime(rs.getString("apptTime"));
                } 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            try{
                if(conn != null)
                conn.close(); }
            catch(SQLException se){
                se.printStackTrace();
            }
        }
        
        return appt;
    }       
    
    
    
    public static void modifyAppt(AppointmentModel appt){
        String sql = null;
        DefaultTableModel tblModel = null;
        Connection conn = null;
        
        String custId = Integer.toString(appt.getCustId()),
                grmId = Integer.toString(appt.getGrmId()),
                petId = Integer.toString(appt.getPetId()),
                notes = appt.getNotes(),
                time = appt.getTime();
        java.sql.Date date = appt.getDate();
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb", "malderson@fetch-mobile-grooming", "Puppy123");             
            PreparedStatement stmt = conn.prepareStatement("UPDATE appointment SET customerId=?, groomerId=?, petId=?, appointmentDate=?, notes=?, apptTime=?"
                    + "WHERE appointmentId=?;");
            
            stmt.setString(1, custId);
            stmt.setString(2, grmId);
            stmt.setString(3, petId);
            stmt.setDate(4, date);
            stmt.setString(5, notes);
            stmt.setString(6, time);
            stmt.setInt(7, appt.getApptId());
            
            int i = stmt.executeUpdate();
            
            if(i>0) {
                JOptionPane.showMessageDialog(null, "Appointment Changed Successfully.", "Result", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "Unable to Change Appointment", "Bad Database Connection", JOptionPane.OK_OPTION);
            }
            
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
    
    
    
    public static void deleteAppt(int id){
        String sql = null;
        DefaultTableModel tblModel = null;
        Connection conn = null;
        
        
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb", "malderson@fetch-mobile-grooming", "Puppy123");             
            PreparedStatement stmt = conn.prepareStatement("DELETE from appointment WHERE appointmentId=" + id + ";");
            
            int i = stmt.executeUpdate();
            
            if(i>0) {
                JOptionPane.showMessageDialog(null, "Appointment Deleted Successfully.", "Result", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "Unable to Delete Appointment", "Result", JOptionPane.OK_OPTION);
            }
            
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
}
