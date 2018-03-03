/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputValidation;
import java.util.regex.*;
/**
 *
 * @author Matt
 */
public class EmailValidator {
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
    public EmailValidator(){
    }
    
    public boolean validate(String inEmail) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(inEmail);
        return matcher.find();
    }
}
