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
public class MiddleInitialFilter extends DocumentFilter{
    
    private final int M_INITIAL_SIZE = 1;
    
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
      
        if ((fb.getDocument().getLength() + str.length()
            - length) <= M_INITIAL_SIZE && str.matches("^[A-Za-z]")) {
            super.replace(fb, offset, length, str.toUpperCase(), attrs);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }    
    
}
