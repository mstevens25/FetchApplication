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
    
    private Pattern pattern;
    private Matcher matcher;
    
    private static final String EMAIL_VERIFICATION = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}"
            + "~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]"
            + "|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a"
            + "-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|"
            + "[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*["
            + "a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\"
            + "x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    
    public EmailValidator(){
        pattern = Pattern.compile(EMAIL_VERIFICATION);
    }
    
    public boolean validate(String inEmail) {
        matcher = pattern.matcher(inEmail);
        return matcher.matches();
    }
}
