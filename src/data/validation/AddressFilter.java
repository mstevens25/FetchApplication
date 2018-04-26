/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.validation;

import java.awt.Toolkit;
import java.util.regex.Pattern;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.Document;
/**
 *
 * @author mattm
 */
public class AddressFilter extends DocumentFilter {
    
    public void insertString(FilterBypass fb, int offset, String str,
      AttributeSet attr) throws BadLocationException {
    
    super.insertString(fb, offset, str, attr);
  }

  public void remove(FilterBypass fb, int offset, int length)
      throws BadLocationException {

    super.remove(fb, offset, length);
  }

  public void replace(FilterBypass fb, int offset, int length, String str,
      AttributeSet attrs) throws BadLocationException {
      
    //String text = fb.getDocument().getText(0, fb.getDocument().getLength());
    if (str.matches("^[#.0-9a-zA-Z\\s,-]+$")) {
        super.replace(fb, offset, length, str, attrs);
    } else {
        Toolkit.getDefaultToolkit().beep();
    }
    
  }
  
}
