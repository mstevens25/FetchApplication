/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.model;
import data.validation.*;
import desktop.*;
import internal.frame.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
/**
 *
 * @author mattm
 */
public class EmployeeModel {
    
    private int employeeId,
                departmentId;
    private String email,
                   pass,
                   phone,
                   firstName,
                   middleInitial,
                   lastName;
    
    
    
    public EmployeeModel(){

    }
    
    public EmployeeModel(int departmentId, String email, String pass, String phone, 
            String firstName, String middleInitial, String lastName) {
        
        this.departmentId = departmentId;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
    }
    
    
    
    public int getEmployeeId() { return employeeId; }
    public int getDepartmentId() {return departmentId; }
    public String getEmail() { return email; }
    public String getPass() { return pass; }
    public String getPhone() { return phone; }
    public String getFirstName() { return firstName; }
    public String getMiddleInitial() { return middleInitial; }
    public String getLastName() { return lastName; }

    
    public void setEmployeeId(int employeeId) {  this.employeeId = employeeId; }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }
    public void setEmail(String email) { this.email = email; }
    public void setPass(String pass) { this.pass = pass; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setMiddleInitial(String middleInitial) { this.middleInitial = middleInitial; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    
    
    public static void addEmployee(EmployeeModel employee) {
        
        Connection conn = null;
           
        try {
            conn = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb", "malderson@fetch-mobile-grooming", "Puppy123"); 
            PreparedStatement stmt = conn.prepareStatement("insert into customer"
                +    " (departmentId, email, pass, phone, firstName, middleInitial, lastName)"
                +    " values (?,?,?,?,?,?,?)");
            
            stmt.setString(1, Integer.toString(employee.getDepartmentId()));
            stmt.setString(2, employee.getEmail());
            stmt.setString(3, employee.getPass());
            stmt.setString(4, employee.getPhone());
            stmt.setString(5, employee.getFirstName());
            stmt.setString(6, employee.getMiddleInitial());
            stmt.setString(7, employee.getLastName());
            
            int i = stmt.executeUpdate();
            
            if(i>0) {
                JOptionPane.showMessageDialog(null, "New Employee Added Successfully.", "Result", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "Unable to Add New Employee", "Result", JOptionPane.OK_OPTION);
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
    
    
    
    public static EmployeeModel chkEmpLogin(String username) {
        
        Connection conn = null;
        String sql = "SELECT * FROM employee";
        EmployeeModel emp = new EmployeeModel();
        emp.setEmail("INVALID");
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb", "malderson@fetch-mobile-grooming", "Puppy123");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                if(rs.getString("email").equalsIgnoreCase(username)){
                    emp.setEmployeeId(rs.getInt("employeeId"));
                    emp.setDepartmentId(rs.getInt("departmentId"));
                    emp.setEmail(rs.getString("email"));
                    emp.setPass(rs.getString("pass"));
                    emp.setPhone(rs.getString("phone"));
                    emp.setFirstName(rs.getString("firstName"));
                    emp.setMiddleInitial(rs.getString("middleInitial"));
                    emp.setLastName(rs.getString("lastName"));
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
        
        return emp;
    }
}
        /*
            
            int columnCount = metaData.getColumnCount();
          
            
            while (rs.next()) {
                for (int count = 1; count <= columnCount; count++) {
                    employees.add(rs.getObject(count));
                }
                //data.add(employees);
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
        */