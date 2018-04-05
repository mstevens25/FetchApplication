/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author mattm
 */
public class GroomerModel {
    private int groomerId;
    private String email,
                   pass,
                   phone,
                   firstName,
                   middleInitial,
                   lastName,
                   addressLine1,
                   addressLine2,
                   city,
                   state,
                   zip;
    
    public GroomerModel() {
    }
    
    public GroomerModel(String email, String pass, String phone, String firstName, String middleInitial,
                    String lastName, String addressLine1, String addressLine2, String city, String state, String zip) { 
        
        this.email = email;
        this.pass = pass;
        this.phone = phone;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
       
               
    public int getGroomerId() { return groomerId; }
    public String getEmail() { return email; }
    public String getPass() { return pass; }
    public String getPhone() { return phone; }
    public String getFirstName() { return firstName; }
    public String getMiddleInitial() { return middleInitial; }
    public String getLastName() { return lastName; }
    public String getAddressLine1() { return addressLine1; }
    public String getAddressLine2() { return addressLine2; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZip() { return zip; }
    
    public void setGroomerId(int groomerID) {  this.groomerId = groomerId; }
    public void setEmail(String email) { this.email = email; }
    public void setPass(String pass) { this.pass = pass; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setMiddleInitial(String middleInitial) { this.middleInitial = middleInitial; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAddressLine1(String addressLine1) { this.addressLine1 = addressLine1; }
    public void setAddressLine2(String addressLine2) { this.addressLine2 = addressLine2; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZip(String zip) { this.zip = zip; }
    
    
    public static void addGroomer(GroomerModel grmr) {
        
        Connection conn = null;
           
        try {
            conn = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb", "malderson@fetch-mobile-grooming", "Puppy123"); 
            PreparedStatement stmt = conn.prepareStatement("insert into groomer"
                +    " (email, pass, phone, firstName, middleInitial, lastName, addressLine1, addressLine2, city, state, zip)"
                +    " values (?,?,?,?,?,?,?,?,?,?,?)");
            
            stmt.setString(1, grmr.getEmail());
            stmt.setString(2, grmr.getPass());
            stmt.setString(3, grmr.getPhone());
            stmt.setString(4, grmr.getFirstName());
            stmt.setString(5, grmr.getMiddleInitial());
            stmt.setString(6, grmr.getLastName());
            stmt.setString(7, grmr.getAddressLine1());
            stmt.setString(8, grmr.getAddressLine2());
            stmt.setString(9, grmr.getCity());
            stmt.setString(10, grmr.getState());
            stmt.setString(11, grmr.getZip());
            
            int i = stmt.executeUpdate();
            
            if(i>0) {
                JOptionPane.showMessageDialog(null, "New Groomer Added Successfully.", "Result", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "Unable to Add New Groomer", "Result", JOptionPane.OK_OPTION);
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
    
    public static GroomerModel setFocus(int focusID){

        
        Connection conn = null;
        String sql = "SELECT * FROM groomer";
        GroomerModel grm = new GroomerModel();
        grm.setGroomerId(-1);
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb", "malderson@fetch-mobile-grooming", "Puppy123");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                if(rs.getInt("groomerId") == focusID){
                    grm.setGroomerId(rs.getInt("groomerId"));
                    grm.setEmail(rs.getString("email"));
                    grm.setPass(rs.getString("pass"));
                    grm.setPhone(rs.getString("phone"));
                    grm.setFirstName(rs.getString("firstName"));
                    grm.setMiddleInitial(rs.getString("middleInitial"));
                    grm.setLastName(rs.getString("lastName"));
                    grm.setAddressLine1(rs.getString("addressLine1"));
                    grm.setAddressLine2(rs.getString("addressLine2"));
                    grm.setCity(rs.getString("city"));
                    grm.setState(rs.getString("state"));
                    grm.setZip(rs.getString("zip"));
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
        
        return grm;
    }
    
    
}
