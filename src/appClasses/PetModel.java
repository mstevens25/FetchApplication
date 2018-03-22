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
public class PetModel {
    private int ownerID,
                petID,
                age;
    private String name,
                   petType,
                   breed;
    private char petSex;
    
    public PetModel(String name, String petType, char petSex, String breed, int age, int ownerID) { 
        
        this.name = name;
        this.petType = petType;
        this.petSex = petSex;
        this.breed = breed;
        this.age = age;
        this.ownerID = ownerID;
    }
       
               
    public int getOwnerID() { return ownerID; }
    public int getPetID() { return petID; }
    public int getAge() { return age; }
    public String getName() { return name; }
    public String getPetType() { return petType; }
    public String getBreed() { return breed; }
    public char getPetSex() { return petSex; }
    
    public void setOwnerID(int ownerID) {  this.ownerID = ownerID; }
    public void setPetID(int petID) { this.petID = petID; }
    public void setAge(int age) { this.age = age; }
    public void setName(String name) { this.name = name; }
    public void setPetType(String petType) { this.petType = petType; }
    public void setBreed(String breed) { this.breed = breed; }
    public void setPetSex(char petSex) { this.petSex = petSex; }
    
    
    public static void addPet(PetModel pet) {
        
        Connection conn = null;
           
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fetchdb", "root", "mysqlpw"); 
            PreparedStatement stmt = conn.prepareStatement("insert into pet"
                +    " (name, type, sex, breed, age, owner)"
                +    " values (?,?,?,?,?,?)");
            
            stmt.setString(1, pet.getName());
            stmt.setString(2, pet.getPetType());
            stmt.setString(3, Character.toString(pet.getPetSex()));
            stmt.setString(4, pet.getBreed());
            stmt.setString(5, Integer.toString(pet.getAge()));
            stmt.setString(6, Integer.toString(pet.getOwnerID()));

            
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

