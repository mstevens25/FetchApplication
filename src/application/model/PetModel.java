/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mattm
 */
public class PetModel {
    private int customerId,
                petId;
    private String name,
                   type,
                   breed;
    private char sex;
    
    public PetModel(String name, String type, char sex, String breed, int customerId) { 
        
        this.name = name;
        this.type = type;
        this.sex = sex;
        this.breed = breed;
        this.customerId = customerId;
    }
       
               
    public int getCustomerId() { return customerId; }
    public int getPetId() { return petId; }
    public String getName() { return name; }
    public String getType() { return type; }
    public String getBreed() { return breed; }
    public char getSex() { return sex; }
    
    public void setOwnerID(int ownerID) {  this.customerId = customerId; }
    public void setPetID(int petID) { this.petId = petId; }
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setBreed(String breed) { this.breed = breed; }
    public void setSex(char sex) { this.sex = sex; }
    
    
    public static void addPet(PetModel pet) {
        
        Connection conn = null;
           
        try {
            conn = DriverManager.getConnection("jdbc:mysql://fetch-mobile-grooming.mysql.database.azure.com/Fetchdb", "malderson@fetch-mobile-grooming", "Puppy123"); 
            PreparedStatement stmt = conn.prepareStatement("insert into pet"
                +    " (customerId, name, type, sex, breed)"
                +    " values (?,?,?,?,?,?)");
              
            stmt.setString(1, Integer.toString(pet.getCustomerId()));
            stmt.setString(2, pet.getName());
            stmt.setString(3, pet.getType());
            stmt.setString(4, Character.toString(pet.getSex()));
            stmt.setString(5, pet.getBreed());
            

            
            int i = stmt.executeUpdate();
            
            if(i>0) {
                JOptionPane.showMessageDialog(null, "New Pet Added Successfully.", "Result", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(null, "Unable to Add New Pet", "Result", JOptionPane.OK_OPTION);
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

