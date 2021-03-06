/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.validation;
import java.util.regex.*;
/**
 *
 * @author Matt
 */
public class EmailFilter {
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
    public EmailFilter(){
    }
    
    public boolean validateFormat(String inEmail) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(inEmail);
        return matcher.find();
    }
    
    public boolean valCompanyEmail (String inEmail) {
        String fetchEmail = "@fetchmobilegrooming.com";   
        String email = inEmail.toLowerCase();
        
        boolean check = email.contains(fetchEmail);
        return check;
    }
}