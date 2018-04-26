/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.validation;

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author mattm
 */
public class ZipCodeFilter extends DocumentFilter{
  
    private final int ZIP_SIZE = 5;
    
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String str,
      AttributeSet attr) throws BadLocationException {
    
        super.insertString(fb, offset, str, attr);
    }

    public void remove(DocumentFilter.FilterBypass fb, int offset, int length)
      throws BadLocationException {

        super.remove(fb, offset, length);
    }

    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String str, 
      AttributeSet attrs) throws BadLocationException {
      
        String text = fb.getDocument().getText(0, fb.getDocument().getLength());
        text += str;
        if ((fb.getDocument().getLength() + str.length()
            - length) <= ZIP_SIZE && str.matches("^[0-9]")) {
            super.replace(fb, offset, length, str, attrs);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
