/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.model;

/**
 *
 * @author Matt
 */
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author mattm
 */
public class CustomerModel {
    
    private int customerId;
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
    
    public CustomerModel(){
    }
    
    public CustomerModel(String email, String pass, String phone, String firstName, String middleInitial,
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
       
               
    
    public int getCustomerId() { return customerId; }
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
    
    public void setCustomerId(int customerId) {  this.customerId = customerId; }
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
    
    
    
    public static void addCustomer(CustomerModel cust) {
        
        Connection conn = null;
           
        try {
            conn = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb", "malderson@fetch-mobile-grooming", "Puppy123"); 
            PreparedStatement stmt = conn.prepareStatement("insert into customer"
                +    " (email, pass, phone, firstName, middleInitial, lastName, addressLine1, addressLine2, city, state, zip)"
                +    " values (?,?,?,?,?,?,?,?,?,?,?)");
            
            stmt.setString(1, cust.getEmail());
            stmt.setString(2, cust.getPass());
            stmt.setString(3, cust.getPhone());
            stmt.setString(4, cust.getFirstName());
            stmt.setString(5, cust.getMiddleInitial());
            stmt.setString(6, cust.getLastName());
            stmt.setString(7, cust.getAddressLine1());
            stmt.setString(8, cust.getAddressLine2());
            stmt.setString(9, cust.getCity());
            stmt.setString(10, cust.getState());
            stmt.setString(11, cust.getZip());
            
            int i = stmt.executeUpdate();
            
            if(i>0) {
                JOptionPane.showMessageDialog(null, "New Customer Added Successfully.", "Result", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "Unable to Add New Customer", "Result", JOptionPane.OK_OPTION);
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
    
    public static CustomerModel setFocus(int focusID){

        
        Connection conn = null;
        String sql = "SELECT * FROM customer";
        CustomerModel cust = new CustomerModel();
        cust.setCustomerId(-1);
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb", "malderson@fetch-mobile-grooming", "Puppy123");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                if(rs.getInt("customerId") == focusID){
                    cust.setCustomerId(rs.getInt("customerId"));
                    cust.setEmail(rs.getString("email"));
                    cust.setPass(rs.getString("pass"));
                    cust.setPhone(rs.getString("phone"));
                    cust.setFirstName(rs.getString("firstName"));
                    cust.setMiddleInitial(rs.getString("middleInitial"));
                    cust.setLastName(rs.getString("lastName"));
                    cust.setAddressLine1(rs.getString("addressLine1"));
                    cust.setAddressLine2(rs.getString("addressLine2"));
                    cust.setCity(rs.getString("city"));
                    cust.setState(rs.getString("state"));
                    cust.setZip(rs.getString("zip"));
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
        
        return cust;
    }
}
