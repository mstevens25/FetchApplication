/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mattm
 */
public class GroomerModel {
    private int groomerID;
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
       
               
    public int getGroomerID() { return groomerID; }
    public String getemail() { return email; }
    public String getpass() { return pass; }
    public String getphone() { return phone; }
    public String getfirstName() { return firstName; }
    public String getmiddleInitial() { return middleInitial; }
    public String getlastName() { return lastName; }
    public String getaddressLine1() { return addressLine1; }
    public String getaddressLine2() { return addressLine2; }
    public String getcity() { return city; }
    public String getstate() { return state; }
    public String getzip() { return zip; }
    
    public void setcustomerID(int groomerID) {  this.groomerID = groomerID; }
    public void setemail(String email) { this.email = email; }
    public void setpass(String pass) { this.pass = pass; }
    public void setphone(String phone) { this.phone = phone; }
    public void setfirstName(String firstName) { this.firstName = firstName; }
    public void setmiddleInitial(String middleInitial) { this.middleInitial = middleInitial; }
    public void setlastName(String lastName) { this.lastName = lastName; }
    public void setaddressLine1(String addressLine1) { this.addressLine1 = addressLine1; }
    public void setaddressLine2(String addressLine2) { this.addressLine2 = addressLine2; }
    public void setcity(String city) { this.city = city; }
    public void setstate(String state) { this.state = state; }
    public void setzip(String zip) { this.zip = zip; }
    
    
    public static void addGroomer(GroomerModel grmr) {
        
        Connection conn = null;
           
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fetchdb", "root", "mysqlpw"); 
            PreparedStatement stmt = conn.prepareStatement("insert into customer"
                +    " (email, pass, phone, firstName, middleInitial, lastName, addressLine1, addressLine2, city, state, zip)"
                +    " values (?,?,?,?,?,?,?,?,?,?,?)");
            
            stmt.setString(1, grmr.getemail());
            stmt.setString(2, grmr.getpass());
            stmt.setString(3, grmr.getphone());
            stmt.setString(4, grmr.getfirstName());
            stmt.setString(5, grmr.getmiddleInitial());
            stmt.setString(6, grmr.getlastName());
            stmt.setString(7, grmr.getaddressLine1());
            stmt.setString(8, grmr.getaddressLine2());
            stmt.setString(9, grmr.getcity());
            stmt.setString(10, grmr.getstate());
            stmt.setString(11, grmr.getzip());
            
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
}
